import java.io.*;
import java.util.*;

public class Main {
	static long[] cnt;
	static int a, b;

	static void parse(long n, long delta) {
		while(n>0) {
			cnt[(int)(n%10)] += delta;
			n /= 10;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
//		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = 1;
			b = Integer.parseInt(st.nextToken());
			
			cnt = new long[10];
			
			long delta = 1;
			
			while(a<=b) {
				for(;a%10!=0 && a<=b; a++) {
					parse(a, delta);
				}
				for(;b%10!=9 && a<=b; b--) {
					parse(b, delta);
				}
				if(a>b) {
					break;
				}
				
				a /= 10;
				b /= 10;
				
				long rowCnt = b-a+1;
				
				for(int i=0;i<10;i++) {
					cnt[i] += rowCnt*delta;
				}
				delta *= 10;
			}
			
			long sum = 0;
			for(int i=1;i<10;i++) {
				sum += cnt[i]*i;
			}
			for(int i = 0; i < 10; i++) {
				System.out.print(cnt[i] + " ");
			}
//			sb.append("#"+t+" "+sum+"\n");
//		}
//		System.out.println(sb);
	}

}
