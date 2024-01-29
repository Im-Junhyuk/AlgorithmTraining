import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Main{

	
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tc = 0; tc <T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				sticker[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				sticker[1][i] = Integer.parseInt(st.nextToken());
			}
			
			if(n == 1) {
				bw.write(Math.max(sticker[0][0], sticker[1][0]) + "\n");
				continue;
			}
			
			sticker[0][1] = sticker[1][0] + sticker[0][1];
			sticker[1][1] = sticker[0][0] + sticker[1][1];
			
			if(n == 2) {
				bw.write(Math.max(sticker[0][1], sticker[1][1]) + "\n");
				continue;
			}
			for(int i = 2; i < n; i++) {
				sticker[0][i] += Math.max(sticker[1][i-1], sticker[1][i-2]);
				sticker[1][i] += Math.max(sticker[0][i-1], sticker[0][i-2]); 
			}
			bw.write(Math.max(sticker[0][n-1], sticker[1][n-1]) + "\n");
			
		}
		bw.flush();
	}
	
}
