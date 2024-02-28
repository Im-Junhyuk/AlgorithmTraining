import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
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
			Set<Integer> set = new HashSet<>();
			
			String str = br.readLine();
			for(int i = 0; i < N; i++) {
				char[] temp = new char[N/4];
				for(int j = i; j < i + N/4; j++) {
					temp[j-i] = str.charAt(j%N);
				}
				
				set.add(Integer.parseInt(String.valueOf(temp), 16));
			}
			
			ArrayList<Integer> candidate = new ArrayList<>();
			candidate.addAll(set);
			Collections.sort(candidate, Collections.reverseOrder());
//			for(int i = 0; i < N; i++) {
//				System.out.print(candidate[i] + " ");
//			}System.out.println();
			sb.append("#")
				.append(t)
				.append(" ")
				.append(candidate.get(K-1))
				.append("\n");
			
		}
		System.out.println(sb);
	}

}
