import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		int[][] board = new int[n][n];
		
		//x가 행이고 y가 열이다.
		int[][] x_acc = new int[n+1][n];
		int[][] y_acc = new int[n][n+1];
		
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int acc = 0;
			for (int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				acc += board[i][j];
				y_acc[i][j+1] = acc; //열우선
			}
		}
		
		int x1, y1, x2, y2;
		

		
		
		for (int t=0; t<m; t++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			
//			for (int x=x1-1; x<=x2-1; x++) {
//				for (int y=y1-1; y<=y2-1; y++) {
//					sum += board[x][y];
//				}
//			}
			
			for (int x=x1-1; x<=x2-1; x++) {
				sum += y_acc[x][y2]-y_acc[x][y1-1];
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}

}
