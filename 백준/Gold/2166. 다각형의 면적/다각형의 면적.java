import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[][] points = new long[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Long.parseLong(st.nextToken());
			points[i][1] = Long.parseLong(st.nextToken());
		}
		double sum1 = 0D;
		double sum2 = 0;
		for(int i = 1; i < N-1; i++) {
			sum1 += points[0][0] * points[i][1] + points[i][0] * points[i+1][1] + points[i+1][0] * points[0][1];
			sum2 += points[0][1] * points[i][0] + points[i][1] * points[i+1][0] + points[i+1][1] * points[0][0];
		}

		System.out.println(String.format("%.1f", Math.abs((sum1-sum2)/2.0)));

	}
}
