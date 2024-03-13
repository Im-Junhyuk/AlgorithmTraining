import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String seat = br.readLine();
		int result = 0;
		
		boolean l = false;
		
		for(int i = 0; i < N; i++) {
			char s = seat.charAt(i);
			if(s == 'L') {
				l = true;
				i++;
			}
				
			result++;
		}
		if(l)
			result++;
		
		System.out.println(result);
	}
}