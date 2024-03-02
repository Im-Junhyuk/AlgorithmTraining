import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Set<String> s1 = new HashSet<String>();
			Set<String> s2 = new HashSet<String>();
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				s1.add(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				s2.add(st.nextToken());
			}
			
			int num = 0;
			if(N < M) {
				for(String str : s1)
					if(s2.contains(str))
						num++;
			} else {
				for(String str : s2)
					if(s1.contains(str))
						num++;
			}
			
			sb.append("#")
				.append(t)
				.append(" ")
				.append(num)
				.append("\n");
		}
		System.out.println(sb);
	}

}