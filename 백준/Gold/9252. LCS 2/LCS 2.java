import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder().append(" ");
		String s1 = sb.append(br.readLine()).toString();
		
		sb = new StringBuilder().append(" ");
		String s2 = sb.append(br.readLine()).toString();
		
		int[][] dp = new int[s1.length()][s2.length()];
		
		for(int i = 1; i < s1.length(); i++) {
			for(int j = 1; j < s2.length(); j++) {
				
				if(s1.charAt(i)== s2.charAt(j) && dp[i-1][j-1] + 1 > Math.max(dp[i-1][j], dp[i][j-1])) {
					dp[i][j]= dp[i-1][j-1] + 1; 
					continue;
				}
				
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
			}
		}
		bw.write(dp[s1.length()-1][s2.length()-1] + "\n");
		
		int i = s1.length() - 1;
		int j = s2.length() - 1;
		sb = new StringBuilder();
		
		while(dp[i][j] > 0) {
			if(dp[i][j] == dp[i-1][j]) {
				i--;
			} else if(dp[i][j] == dp[i][j-1]) {
				j--;
			} else {
				sb.append(s1.charAt(i));
				i--;
				j--;
			}
		}
		bw.write(sb.reverse().toString() + "\n");
		bw.flush();
	}

}