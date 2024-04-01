import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static final long p = 1234567891;
					
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long num1 = fac(N) % p;
			long num2 = fac(N-R) %p;
			long num3 = fac(R) %p;
			long num4 = exponential((num2 * num3 )% p , p-2) %p;
			long result = (num1 * num4) %p ;
			
//			System.out.println("1 " + num1);
//			System.out.println("2 " + num2);
//			System.out.println("3 " + num3);
//			System.out.println("4 " + num4);
//			System.out.println(result);
			
			sb.append("#")
				.append(t)
				.append(" ")
				.append(result)
				.append("\n");
			
			
			
			
			
			
		}
		
		System.out.print(sb);
		test();
	}
	
	static long fac(long num) {
//		System.out.println("fac");
		if(num == 1)
			return 1;
		
		long result = 1;
		for(long i = 1; i <= num; i++) {
			result *= i;
			result %= p;
		}
		return result;
	}
	
	static long exponential(long num1, long num2) {
//		System.out.println("exp");
		if(num2 == 0)
			return 1;
		
		if(num2 == 1)
			return num1;
		
		long temp = exponential(num1, num2/2);
		if(num2 %2 == 0)
			return (temp * temp) % p;
		else
			return (((temp * temp) %p )* num1) % p;
	}
	static void test() {
//		int f = fac(7);
//		int e = exponential(10, 20);
//		
//		System.out.println(f + " " + e);
	}
}

