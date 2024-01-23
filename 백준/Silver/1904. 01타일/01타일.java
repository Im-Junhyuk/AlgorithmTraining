import java.util.Scanner;

public class Main {
	static int dp[];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		dp = new int[N+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		if (N > 1) {
			dp[2] = 2;
			dp(N);
		}
		

		System.out.println(dp[N]);
		
	}
	static int dp(int N) {
		for(int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
		return dp[N];
	}
}
