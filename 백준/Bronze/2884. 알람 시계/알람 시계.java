import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		
		if(minute >= 45)
			minute -= 45;
		else if(hour >= 1) {
			hour--;
			minute += 15;
		} else {
			hour = 23;
			minute += 15;
		}
		
		sb.append(hour)
			.append(" ")
			.append(minute);
		
		System.out.println(sb);
	}
}