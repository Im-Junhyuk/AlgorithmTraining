import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
//				A[i][j] = Integer.parseInt(st.nextToken());
				A[i][j] = str.charAt(j) - '0';
			}
		}
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				B[i][j] = str.charAt(j) - '0';
			}
		}
		boolean b = false;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				
				if(A[i][j] != B[i][j]) {
					if (i > N - 3 || j > M - 3) {
						count = -1;
						b = true;
						break;
					}
					else {
						reversedMatrix(A, i, j);
						count++;
					}
						
				}
			}
			if (b == true)
				break;
		}
		System.out.println(count);
	}
	public static void reversedMatrix(int [][] mat, int x, int y) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (mat[x+i][y+j] == 0)
					mat[x+i][y+j] = 1;
				else 
					mat[x+i][y+j] = 0;
			}
		}
	}
}
