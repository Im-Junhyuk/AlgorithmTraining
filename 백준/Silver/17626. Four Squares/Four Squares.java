import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		int result;
		for(int i = 2; i < n+1; i++) {
			result  = Integer.MAX_VALUE;
			for(int j =1; j * j <= i; j++) {
				result = Math.min(result, dp[i - j * j]);
			}
			dp[i] = result +1;
		}
		
		System.out.println(dp[n]);

	}
}