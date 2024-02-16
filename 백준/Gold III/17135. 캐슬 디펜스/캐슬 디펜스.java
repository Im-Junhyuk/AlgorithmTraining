import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int comCnt = 0;
	static int[] temp;
	
	static ArrayList<ArcherPosition> archers;
	static int[][] tempBattleField;
	
	static int N;
	static int M;
	static int D;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		int[][] battleField = new int[N][M];
		int enemyNum = 0;

		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				battleField[n][m] = Integer.parseInt(st.nextToken());
				if(battleField[n][m] == 1)
					enemyNum++;
			}
		}
		
		archers = new ArrayList<>();
		temp = new int[3];
		combination(0, 0);

		int maxEnemyKill = Integer.MIN_VALUE;
		
		// case for each combination
		for(ArcherPosition archerPosition : archers) {
			
			// init
//			int curEnemyKill = 0;
			tempBattleField = new int[N][M];
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					tempBattleField[n][m] = battleField[n][m];
				}
			}
			
			int[] aY = new int[3];
			aY[0] = archerPosition.a1;
			aY[1] = archerPosition.a2;
			aY[2] = archerPosition.a3;
			int aX = N;
			
			while(aX > 0) {
			
				Enemy[] killedEnemis = new Enemy[3];
				for(int i = 0; i < 3; i++) {
					killedEnemis[i] = bfsKill(aX, aY[i]);
				}
				
				for(Enemy e : killedEnemis) {
					if(e != null)
						tempBattleField[e.x][e.y] = 0;
				}
				
				aX--;
			}
			int remainingEnemy = 0;
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					if(tempBattleField[n][m] == 1)
						remainingEnemy++;
				}
			}
			maxEnemyKill = Math.max(maxEnemyKill, enemyNum - remainingEnemy);
		}
		
		System.out.println(maxEnemyKill);
	}
	
	static class Enemy{
		int x; 
		int y;
		Enemy(int x, int y){
			this.x = x; 
			this.y = y;
		}
	}
	static class ArcherPosition{
		int a1;
		int a2;
		int a3;
		ArcherPosition(int a1, int a2, int a3){
			this.a1 = a1;
			this.a2 = a2;
			this.a3 = a3;
		}
	}
	
	// get archer positions 0 ~ M-1 for each case
	static void combination(int start, int len) {
		if(len == 3) {
			archers.add(new ArcherPosition(temp[0], temp[1], temp[2]));
			return;
		}
		
		for(int i = start; i < M; i++) {
			temp[len] = i;
			combination(i+1, len+1);
		}
	}
	
	static int[] dx = {0, -1, 0};
	static int[] dy = {-1, 0, 1};
	
	static Enemy bfsKill(int aX, int aY) {
		
		Queue<Enemy> q = new LinkedList<Enemy>();
		q.add(new Enemy(aX-1, aY));
		boolean[][] visited = new boolean[N][M];
		
		while(!q.isEmpty()) {
			Enemy enemy = q.poll();
			if(visited[enemy.x][enemy.y])
				continue;
			visited[enemy.x][enemy.y] = true;
			
			if(tempBattleField[enemy.x][enemy.y] == 1)
				return new Enemy(enemy.x, enemy.y);
			for(int d = 0; d < 3; d++) {
				int nextX = enemy.x + dx[d];
				int nextY = enemy.y + dy[d];
				
				if(nextX >= 0 && nextX < aX && nextY >= 0 && nextY < M
						&& visited[nextX][nextY] == false
						&& Math.abs(aX - nextX) + Math.abs(aY - nextY) <= D)
					q.add(new Enemy(nextX, nextY));
			}
		}
		return null;
	}
}
