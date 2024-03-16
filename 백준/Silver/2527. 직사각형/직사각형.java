import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] x = new int[4];
		int[] y = new int[4];
		
		for(int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			char result = ' ';
			
			for(int i = 0; i < 4; i++) {
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			if( (x[2] > x[1]) || (x[3] < x[0]) || (y[0] > y[3]) || (y[1] < y[2]))
				result = 'd';
			else if( (x[0] == x[3] && y[0] == y[3]) || (x[0] == x[3] && y[1] == y[2])
					|| (x[1] == x[2] && y[1] == y[2]) || (x[1] == x[2] && y[0] == y[3]) )
				result = 'c';
			else if( x[0] == x[3] || y[0] == y[3] || x[1] == x[2] || y[1] == y[2])
				result = 'b';
			else 
				result = 'a';
			
			sb.append(result)
				.append("\n");
		}
		System.out.println(sb);
	}
}
