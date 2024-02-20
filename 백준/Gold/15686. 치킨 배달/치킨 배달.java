import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] city;
	static ArrayList<ArrayList<Integer>> comList;
	static int[] tempCom;
	static int comCnt = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		city = new int[N][N];
		ArrayList<ChickenRest> restaurants = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j] == 2) {
					restaurants.add(new ChickenRest(i, j));
				}
			}
		}
		
		if(M < restaurants.size()) {
			
			int deleteNum = restaurants.size() - M;
			ArrayList<Integer> uselessList = null;
			tempCom = new int[deleteNum];
			comList = new ArrayList<>();
			combination(0, 0, deleteNum, restaurants.size());
			
			int minChickenDist = Integer.MAX_VALUE;
			for(int c = 0; c < comList.size(); c++) {
				
				for(int i : comList.get(c)) {
					city[restaurants.get(i).x][restaurants.get(i).y] = 0;
				}
					
				int curCDist = getChickenDist();
				if(minChickenDist > curCDist) {
					minChickenDist = curCDist;
					uselessList = comList.get(c);
				}
				
				for(int i : comList.get(c)) {
					city[restaurants.get(i).x][restaurants.get(i).y] = 2;
				}				
			
			}

			for(int i : uselessList) {
				ChickenRest c = restaurants.get(i);
				city[c.x][c.y] = 0;
			}
		}
		
		System.out.println(getChickenDist());
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(city[i][j] + " ");
//			}
//			System.out.println();
//		}

		
	}
	
	static void combination(int start, int len, int destLen, int limit) {
		if(len == destLen) {
			comList.add(new ArrayList<>());
			for(int i = 0; i < destLen; i++) {
				comList.get(comCnt).add(tempCom[i]);
			}
			comCnt++;
			return;
		}

		for(int i = start; i < limit; i++) {
			tempCom[len] = i;
			combination(i+1, len+1, destLen, limit);
		}
	}
	
	static class ChickenRest{
		int x; 
		int y;
		public ChickenRest(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int getChickenDist() {
		int cDist = 0;

		for(int i = 0; i < city.length; i++) {
			for(int j = 0; j < city[i].length; j++) {
				if(city[i][j] == 1)
					cDist += getOneChickenDist(i, j);
			}
		}
		return cDist;
	}
	
	static int getOneChickenDist(int x, int y) {
		int minDist = Integer.MAX_VALUE;
		for(int i = 0; i < city.length; i++) {
			for(int j = 0; j < city[i].length; j++) {
				if(city[i][j] == 2)
					minDist = Math.min(minDist, Math.abs(i - x) + Math.abs(j - y));
			}
		}
		
		return minDist;
	}
	
	static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, 0));
		boolean[][] visited = new boolean[city.length][city.length];
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(city[cur.x][cur.y] == 2)
				return cur.dist;
			
			if(visited[cur.x][cur.y])
				continue;
			visited[cur.x][cur.y] = true;
			
			for(int d = 0; d < 4; d++) {
				int newX = cur.x + dx[d];
				int newY = cur.y + dy[d];
				
				if(newX >= 0 && newX < city.length && newY >= 0 && newY < city.length
						&& visited[newX][newY] == false)
					q.add(new Node(newX, newY, cur.dist+1));
			}
		}
		return -1;
	}
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	
	static class Node{
		int x; 
		int y;
		int dist;
		Node(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}