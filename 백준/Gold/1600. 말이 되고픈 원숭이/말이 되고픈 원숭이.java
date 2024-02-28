import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int W;
	static int H;
	static int K;
	
	static int[] dxM = {0, 0, 1, -1};
	static int[] dyM = {1, -1, 0, 0};
	static int[] dxK = {2, 2, 1, 1, -1, -1, -2, -2};
	static int[] dyK = {1, -1, 2, -2, 2, -2, 1, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[H][W];
		for(int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for(int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][][] visited = new boolean[H][W][K+1];
		
		Queue<Monkey> q = new LinkedList<>();
		q.add(new Monkey(0, 0, 0, 0));
		
		while(!q.isEmpty()) {
			Monkey cur = q.poll();
			
			int x = cur.x;
			int y = cur.y;
			int k = cur.k;
			int move = cur.move;

			if(x == H-1 && y == W-1) {
				System.out.println(move);
				return;
			}
				
			
			if(visited[x][y][k])
				continue;
			
			visited[x][y][k] = true;
			
			for(int d = 0; d < 4; d++) {
				int newX = x + dxM[d];
				int newY = y + dyM[d];
				
				if(newX >= 0 && newY >= 0 && newX < H && newY < W 
						&& map[newX][newY] == 0
						&& visited[newX][newY][k] == false) {
					q.add(new Monkey(newX, newY, k, move+1));
				}
			}
			
			if(k < K) {
				for(int d = 0; d < 8; d++) {
					int newX = x + dxK[d];
					int newY = y + dyK[d];
					
					if(newX >= 0 && newY >= 0 && newX < H && newY < W 
							&& k < K
							&& map[newX][newY] == 0
							&& visited[newX][newY][k+1] == false) {
						q.add(new Monkey(newX, newY, k+1, move+1));
					}
				}
			}
		}
		
		System.out.println(-1);
	}
	static class Monkey{
		int x;
		int y;
		int k;
		int move;
		Monkey(int x, int y, int k, int move) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.move = move;
		}
	}
}
