import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	
	static int[][] map;
	static int[][] dp;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				dp[n][m] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
	}
	
	static int dfs(int x, int y) {
		if(x == N-1 && y == M-1) {
			return 1;
		}
		
		if(dp[x][y] != -1)
			return dp[x][y];
		dp[x][y] = 0;
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(!isInRange(nx, ny))
				continue;
			
			if(map[nx][ny] < map[x][y]) {
				if(dp[nx][ny] == -1)
					dp[x][y] += dfs(nx, ny);
				else
					dp[x][y] += dp[nx][ny];
			}
		}
		
		return dp[x][y];
			
	}
	
	static boolean isInRange(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < M)
			return true;
		return false;
	}
}

