import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
	
	
	static int[][] mapCopy;
	static int[][] map;
	
	static int N;
	static int W;
	static int H;
	
	static int curScore;
	static int maxScore;
	static int[] hit;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			int total = 0;
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;  j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0)
						total++;
				}
			}
			
			hit = new int[N];
			maxScore = 0;
			
			permu(0);
			sb.append("#")
				.append(t)
				.append(" ")
				.append(total - maxScore)
				.append("\n");
			
			
		}
		System.out.print(sb.toString());
	}
	
	static void permu(int len) {
		if(len == N) {
			curScore = 0;
			game();
			maxScore = Math.max(curScore, maxScore);
			display();
			return;
		}
		
		for(int i = 0; i < W; i++) {
			hit[len] = i;
			permu(len+1);
		}
	}
	
	static void game() {
		
		mapCopy = new int[H][W];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				mapCopy[i][j] = map[i][j];
			}
		}
		for(int i = 0; i < N; i++) {
			int x = 0;
			int y = hit[i];
			
			while(x < H) {
				if(mapCopy[x][y] != 0) {
					explode(x, y);
					break;
				}
				x++;
			}
			
			drop();
		}
	}
	
	static void explode(int x, int y) {
		curScore++;
		
		int len = mapCopy[x][y];
		mapCopy[x][y] = 0;
		for(int d = 0; d < 4; d++) {
			int nx = x;
			int ny = y;
			for(int l = 0; l < len-1; l++) {
				nx += dx[d];
				ny += dy[d];
				
				if(nx < 0 || nx >= H || ny < 0 || ny >= W)
					break;
				
				if(mapCopy[nx][ny] == 0)
					continue;
				explode(nx, ny);
				
			}
		}
	}
	
	static void drop() {
		for(int col = 0; col < W; col++) {
			Queue<Integer> q = new LinkedList<Integer>();
			for(int row = H-1; row >= 0; row--) {
				if(mapCopy[row][col] == 0)
					continue;
				q.add(mapCopy[row][col]);
				mapCopy[row][col] = 0;
			}
			if(!q.isEmpty()) {
				for(int row = H-1; row >= 0; row--) {
					mapCopy[row][col] = q.poll();
					if(q.isEmpty())
						break;
				}
			}
		}
	}
	static void display() {
//		for(int i = 0; i < H; i++) {
//			for(int j = 0; j < W; j++) {
//				System.out.print(mapCopy[i][j] + " ");
//			}System.out.println();
//		}System.out.println();
	}
}