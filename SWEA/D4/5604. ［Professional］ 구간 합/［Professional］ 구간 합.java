import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static long[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		dp = new long[20];
		
		dp[0] = 0;
		dp[1] = 45;
		
		for(int i = 2; i <= 15; i++) {
			dp[i] = (long) Math.pow(10, i-1) * dp[1] + 10 * dp[i-1];
		}
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());
			
			
			
			
			
			long result = getSum(end) - getSum(start-1);
			
			sb.append("#")
				.append(t)
				.append(" ")
				.append(result)
				.append("\n");
			
//			sb.append("end ")
//				.append(getSum(end))
//				.append(" start-1 ")
//				.append(getSum(start-1))
//				.append("\n");
		}
		
		System.out.print(sb);
//		System.out.println("-------");
//		for(int i = 0; i < dp.length;i++) {
//			System.out.println(dp[i]);
//		}
	}
	
	static long getSum(long num) {
		if(num == -1)
			return 0;
		
		long result = 0;
		String str = String.valueOf(num);
//		System.out.println("str " + str);
		for(int i = str.length()-1; i >= 0; i--) {
			
			if(i == 0) {
				for(int j = 1; j <= num; j++) {
					result += j;
				}
				continue;
			}
			long temp = num / (long) Math.pow(10, i);
			int sum = 0;
			for(int j = 0; j < temp; j++) {
				sum += j;
			}
//			sum++;
//			result += sum * dp[i];
			result += sum * (long) Math.pow(10, i) + temp * dp[i];
			num %= (long) Math.pow(10,  i);
			result += (num+1) * temp;
			
		}
		
		
		
		return result;
	}
}