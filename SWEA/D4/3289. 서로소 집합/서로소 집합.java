import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] group;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#")
				.append(t)
				.append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			
			group = new int[N+1];
			for(int n = 0; n <= N; n++) {
				group[n] = n;
			}
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int inst = Integer.parseInt(st.nextToken());
				int f1 = Integer.parseInt(st.nextToken());
				int f2 = Integer.parseInt(st.nextToken());
				
				int group1 = find(f1);
				int group2 = find(f2);
				switch (inst) {
				case 0:
					union(group1, group2);
					break;
				case 1:
					if(group1 == group2)
						sb.append(1);
					else
						sb.append(0);
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int find(int f) {
		if(group[f] == f)
			return f;
		
		return (group[f] = find(group[f]));
	}
	
	static void union(int g1, int g2) {
		if(g1 > g2)
			group[g1] = g2;
		else
			group[g2] = g1;
		
	}
}