import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxInt = Integer.MIN_VALUE;
		int minInt = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			maxInt = Math.max(maxInt, num);
			minInt = Math.min(minInt, num);
		}
		System.out.println(minInt + " " + maxInt);
	}
}