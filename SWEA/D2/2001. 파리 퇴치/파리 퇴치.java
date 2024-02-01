import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] flyArr = new int[N+1][N+1];
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					flyArr[i][j] = Integer.parseInt(st.nextToken()) + flyArr[i-1][j] + 
							flyArr[i][j-1] - flyArr[i-1][j-1];
				}
			}
			
			int maxFly = Integer.MIN_VALUE;
			for(int i = M; i <= N; i++) {
				for(int j = M; j <= N; j++) {
					maxFly = Math.max(maxFly
							, flyArr[i][j] - flyArr[i-M][j] - flyArr[i][j-M] 
									+ flyArr[i-M][j-M]);
				}
			}
		
			sb.append("#" + tc + " " + maxFly + "\n");
			
		}
		System.out.println(sb);
	}

}
