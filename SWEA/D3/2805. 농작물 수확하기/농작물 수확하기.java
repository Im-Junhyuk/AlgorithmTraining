import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
	
	static int sum;
	static int mid;
	static int[][] farm;
	static boolean[][] visited;
	static int N;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String args[]) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++){
			N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split("");
				for(int j = 0; j < N; j++) {
					farm[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			visited = new boolean[N][N];
			sum = 0;
			mid = N/2;
			
			harvest(mid, mid);
			
			System.out.println("#" + test_case + " " + sum);
		}
	}
	
	public static void harvest(int x, int y) {
		if( Math.abs(mid - x) + Math.abs(mid - y) > N/2 || visited[x][y] == true) {
			return;
		}
		
		visited[x][y] = true;
		sum += farm[x][y];
		
		for(int d = 0; d < 4; d++) {
			harvest(x+dx[d], y+dy[d]);
		}
	}
}