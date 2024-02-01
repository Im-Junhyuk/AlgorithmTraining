import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		// get input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sLength = Integer.parseInt(st.nextToken());
		int pLength = Integer.parseInt(st.nextToken());
		
		String s = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int letter[] = new int[4];
		
		// init
		for(int i = 0; i < pLength; i++) {
			letter[charToInt(s.charAt(i))]++;
		}
		
		
		// slicing string
		int start = 0;
		int end = sLength - pLength + 1;
		int count = 0;
		
		while(true) {
			// check that is good
			if(letter[0] >= A && letter[1] >= C && letter[2] >= G && letter[3] >= T)
				count++;
			
			// go to next
			if(start+1 >= end)
				break;
			
			letter[charToInt(s.charAt(start))]--;
			letter[charToInt(s.charAt(start + pLength))]++;
			
			start++;

		}
		bw.write(String.valueOf(count));
		bw.flush();
		
	}
	
	static int charToInt(char c) {
		switch (c) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		}
		return 0;
	}

}