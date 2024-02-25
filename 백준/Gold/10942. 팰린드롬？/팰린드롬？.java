import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] numArr;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		numArr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 0 is un inited, 1 is yes, -1 is no
		dp = new int[N+1][N+1];
		for(int i = 0; i < N+1; i++) {
			for(int j = 0; j < N+1; j++) {
				dp[i][j] = -1;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			sb.append(pel(S, E))
				.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static int pel(int s, int e) {
		if(s >= e) 
			return 1;

		
		if(dp[s][e] == 0)
			return 0;
		else if(dp[s][e] == 1)
			return 1;
		else if(dp[s][e] == -1) {
			if(numArr[s] != numArr[e]) {
				dp[s][e] = 0;
				return 0;
			} else {
				dp[s][e] = pel(s+1, e-1);
				return dp[s][e];
			}
		}
		
		return 0;
			
	}
}

