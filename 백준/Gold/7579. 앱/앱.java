import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N+1];
		int[] C = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] table = new int[2][M+1];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j <= M; j++) {
				table[i][j] = 100000001;
			}
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= M; j++) {
				if(A[i] >= j)
					table[i%2][j] = Math.min(C[i], table[(i-1)%2][j]);
				else
					table[i%2][j] = Math.min(table[(i-1)%2][j-A[i]] + C[i], table[(i-1)%2][j]);
			}
		}
		
		System.out.println(table[N%2][M]);
//		for(int i = 0; i <= N; i ++) {
//			for(int j = 0; j <= M; j++) {
//				System.out.print(table[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
}