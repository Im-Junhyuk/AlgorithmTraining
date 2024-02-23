import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int validNum = 0;
		for(int i = 0; i < 5; i++) {
			int num = Integer.parseInt(st.nextToken());
			validNum += Math.pow(num, 2) % 10;
		}
		System.out.println(validNum%10);
	}
}
