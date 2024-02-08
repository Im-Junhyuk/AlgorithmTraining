import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] table = new int[N+1][L+1];
			
			int[] score = new int[N+1];
			int[] calorie = new int[N+1];
			
			for(int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine());
				
				score[n] = Integer.parseInt(st.nextToken());
				calorie[n] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= L; j++) {
					if(calorie[i] > j) {
						table[i][j] = table[i-1][j];
						continue;
					}
					
					table[i][j] = Math.max(table[i-1][j], table[i-1][j-calorie[i]] + score[i]);
				}
			}
			
			sb.append("#")
			.append(t)
			.append(" ")
			.append(table[N][L])
			.append("\n");
		}
		
		System.out.println(sb);
	}

}