import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] sour;
	static int[] bitter;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];

		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		int minGap = Integer.MAX_VALUE;
		int maxV = (int) Math.pow(2, N); 
		
		for(int i = 1; i < maxV; i++) {
			int sum = 0;
			int mul = 1;
			int bit = 1;
			
			for(int j = 0; j < N; j++) {
				if((i & (bit << j)) != 0) { // it chosen
					mul *= sour[j];
					sum += bitter[j];
				}
			}
			
			minGap = Math.min(minGap, Math.abs(sum - mul));
		}
		
		bw.write(String.valueOf(minGap));
		bw.flush();
	}

}
