import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		int N, M;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] intArray = new int[N+1][N+1];
		
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N+1; j++) {
				intArray[i][j] = Integer.parseInt(st.nextToken());
				intArray[i][j] = intArray[i][j] + intArray[i-1][j] + intArray[i][j-1] - intArray[i-1][j-1];
			}
		}
		
		for(int i = 0; i < M; i++) {
			int x1, y1, x2, y2;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			int result = intArray[x2][y2] - intArray[x2][y1-1] - intArray[x1-1][y2] + intArray[x1-1][y1-1];
			bw.write(result + "\n");
		}
		
		bw.flush();
	}

}