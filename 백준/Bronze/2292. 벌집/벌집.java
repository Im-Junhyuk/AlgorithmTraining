import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		N--;
		int cnt = 1;
		
		while(N > 0) {
			N = N - cnt * 6;
			cnt++;
		}
		System.out.println(cnt);
	}
}