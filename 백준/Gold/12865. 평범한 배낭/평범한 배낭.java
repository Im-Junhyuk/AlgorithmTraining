import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] item = new int[N+1][2];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// dp
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 0; j < K+1; j++) {
				if(j >= item[i][0]) {
					dp[i][j] = Math.max(dp[i-1][j], item[i][1] + dp[i-1][j - item[i][0]]);
				} else { 
					dp[i][j] = dp[i-1][j];	
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}