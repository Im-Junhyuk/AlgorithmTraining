import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] dpTable;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		dpTable = new int[30][30];
		
		for(int n = 1; n < 30; n++) {
			for(int k = 0; k <= n; k++) {
				if(n == k || k == 0)
					dpTable[n][k] = 1;
				else
					dpTable[n][k] = dpTable[n-1][k-1] + dpTable[n-1][k];
			}
		}
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < TC; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(dpTable[M][N])
				.append("\n");
			
		}
		
		System.out.println(sb);
	}
	static int dp(int n, int k) {
		if(n ==k || k == 0)
			return 1;
		
		if(dpTable[n][k] != 0)
			return dpTable[n][k];
		
		return dpTable[n][k] = dp(n-1, k-1) + dp(n-1, k);
	}
}
