import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] stuff = new int[N][2];
			int[][] result = new int[N+1][K+1];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				stuff[i][0] = Integer.parseInt(st.nextToken());
				stuff[i][1] = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j <= K; j++) {
					if(stuff[i][0] <= j)
						result[i+1][j] = Math.max(result[i][j], stuff[i][1] + result[i][j-stuff[i][0]]);
					else 
						result[i+1][j] = result[i][j];
				}
			}
			
			sb.append("#")
				.append(t)
				.append(" ")
				.append(result[N][K])
				.append("\n");
			
		}
		System.out.println(sb);
		

	}
}
