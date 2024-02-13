import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int v5 = N/5;
		N = N%5;
		
		while(N%3 != 0) {

			N += 5;
			v5--;
			if(v5 == -1) {
				System.out.println(-1);
				return;
			}
		}
		
		int v3 = N/3;
		System.out.println(v3+v5);
		
	}

}
