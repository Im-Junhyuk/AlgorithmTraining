import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[H][W];
		int[][] B = new int[H+X][W+Y];
		
		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W + Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		int x;
		int y;
		
		for(int i = 0; i < H; i++) {
			x = i - X;
			for(int j = 0; j < W; j++) {
				y = j - Y;
				if (x < 0 || y < 0) {
					A[i][j] = B[i][j];
				} else {
					A[i][j] = B[i][j] - A[x][y];
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				bw.write(A[i][j] + " ");
//				System.out.print(A[i][j] + " ");
			}
//			System.out.println();
			bw.write("\n");
		}
		bw.flush();
	}
}

