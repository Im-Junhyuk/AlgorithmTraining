import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int[][][] dp = new int[N+1][N+1][3];
		
		Queue<Pipe> q = new LinkedList<>();
		q.add(new Pipe(0, 1, 0));
		int arrived = 0;
		
		dp[1][2][0] = 1;

		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(house[i][j] == 0 && !(i == 1 && j == 2)) {
					dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
					if(house[i-1][j] != 1 && house[i][j-1] != 1)
						dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
					dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
				}
			}
		}
		
		System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);
	}
	
	static class Pipe{
		int x;
		int y;
		int state;
		Pipe(int x, int y, int state){
			this.x = x;
			this.y = y;
			this.state = state; // 가로 0, 대각선 1, 세로 2
		}
	}
}
