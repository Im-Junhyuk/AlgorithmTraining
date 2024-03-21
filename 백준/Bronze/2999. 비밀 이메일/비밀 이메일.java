import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int candidate = 1;
		int R=1;
		
		while(candidate <= Math.sqrt(str.length())) {
			if(str.length()%candidate == 0 && candidate <= str.length()/candidate)
				R = candidate;
			candidate++;
		}
		
		StringBuilder sb = new StringBuilder(); 
		int s = 0;
		for(int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(s));
			s += R;
			if(s >= str.length()) {
				s = s - str.length() + 1;
			}
		}
		System.out.println(sb);
	}
}
