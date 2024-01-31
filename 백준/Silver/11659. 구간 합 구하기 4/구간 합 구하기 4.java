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
		
		int[] intArray = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			intArray[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sumArray = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			sumArray[i] = sumArray[i-1] + intArray[i-1];
		}


		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int fir = Integer.parseInt(st.nextToken());
			int sec = Integer.parseInt(st.nextToken());
			int sum = sumArray[sec] - sumArray[fir-1];
			bw.write(sum + "\n");
		}
		
		bw.flush();
	}

}
