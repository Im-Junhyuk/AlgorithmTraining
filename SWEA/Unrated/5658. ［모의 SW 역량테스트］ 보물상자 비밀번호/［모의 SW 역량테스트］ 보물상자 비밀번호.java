import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {



	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Integer[] candidate = new Integer[N];
			
			String str = br.readLine();
			for(int i = 0; i < N; i++) {
				char[] temp = new char[N/4];
				for(int j = i; j < i + N/4; j++) {
					temp[j-i] = str.charAt(j%N);
				}
				
				candidate[i] = Integer.parseInt(String.valueOf(temp), 16);
			}
			
			Arrays.sort(candidate, Collections.reverseOrder());
			//for(int i = 0; i < N; i++) {
			//	System.out.print(candidate[i] + " ");
			//}System.out.println();
			sb.append("#")
				.append(t)
				.append(" ")
				.append(candidate[K-1])
				.append("\n");
			
		}
		System.out.println(sb);
	}

}
