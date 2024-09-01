import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N % 2 == 1) {
			System.out.println(0);
			return;
		}
		
		int[] dp = new int[N+1];
		dp[2] = 3;
		
		for(int i = 4; i <= N; i+=2) {
			dp[i] = 2;
			
			dp[i] += dp[2] * dp[i-2];
			
			for(int j = 2; j < i-2; j+=2) {
				dp[i] += 2 * dp[j];
			}
		}
		
		System.out.println(dp[N]);
	}
	
}