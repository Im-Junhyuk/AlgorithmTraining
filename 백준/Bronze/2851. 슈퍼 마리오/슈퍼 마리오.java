import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] mr = new int[10];
		for(int i = 0; i < 10; i++) {
			mr[i] = Integer.parseInt(br.readLine());
		}
		
		int score = 0;
		
		for(int i = 0; i < 10; i++) {
			int nScore = score + mr[i];
			if(Math.abs(100-score) >= Math.abs(100 - nScore))
				score =nScore;
			else 
				break;
		}
		System.out.println(score);
	}
}