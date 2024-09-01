import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Set<Integer> set = new HashSet<>();
		int[] dp = new int[k+1];
		for(int i = 0; i < k+1; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		dp[0] = 0;
		
		for(int i = 0; i < n; i++) {
			int coin = Integer.parseInt(br.readLine());
			if(coin > k || set.contains(coin))
				continue;
			
			set.add(coin);
			
			for(int j = coin; j < k+1; j++) {
				if(dp[j-coin] != Integer.MAX_VALUE)
					dp[j] = Math.min(dp[j], dp[j-coin] + 1);
			}
			
//			System.out.println("i =" + i);
//			for(int l = 0; l < k+1; l++) {
//				
//				System.out.print(dp[l] + " ");
//				
//			}System.out.println();
			
		}
		
		if(dp[k] == Integer.MAX_VALUE) {
			System.out.println("-1");
			return;
		}
		
		System.out.println(dp[k]);
		
//		for(int i = 0; i < k+1; i++) {
//			System.out.print(dp[i] + " ");
//		}
	}
	
}