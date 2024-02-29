import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] value = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				value[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][3];
		int result = Integer.MAX_VALUE;
		
		for(int i = 0; i < 3; i++) {
			
			for(int j = 0; j < 3; j++) {
				if(i == j)
					dp[0][j] = value[0][j];
				else 
					dp[0][j] = 1000000000;
			}
			for(int x = 1; x < N; x++) {
				dp[x][0] = Math.min(dp[x-1][1], dp[x-1][2]) + value[x][0];
				dp[x][1] = Math.min(dp[x-1][0], dp[x-1][2]) + value[x][1];
				dp[x][2] = Math.min(dp[x-1][1], dp[x-1][0]) + value[x][2];
			}
//			for(int x = 0; x < N; x++) {
//				for(int y = 0; y < 3; y++) {
//					System.out.print(dp[x][y] + " ");
//					
//				}
//				System.out.println();
//			}
			for(int x = 0; x < 3; x++) 
				if(i != x) 
					result = Math.min(result, dp[N-1][x]);
		}
		
		System.out.println(result);
	}
}

