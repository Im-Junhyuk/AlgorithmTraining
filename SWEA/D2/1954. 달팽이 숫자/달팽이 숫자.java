import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input_snail.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] snail = new int[N][N];
			
			int i = 0;
			int j = 0;
			int d = 0;
			int s = 1;
			int end = N * N;
			while(s <= end) {
				snail[i][j] = s;
				
				if(i+dx[d] < 0 || i+dx[d] >= N || j+dy[d] < 0 || j+dy[d] >= N 
						|| snail[i+dx[d]][j+dy[d]] != 0)
					d = (d+1)%4;
				i += dx[d];
				j += dy[d];
				s++;
			}
            bw.write("#" + tc + "\n");

			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					bw.write(snail[x][y] + " ");
				}
				bw.write("\n");
			}
			
			bw.flush();
		}
		
	}

}