import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] array = new int[n];
		int[] accumulate = new int[n+1];
		int acc = 0;
		
		for (int i=0; i<n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			acc += array[i];
			accumulate[i+1] = acc;
		}

		
		StringBuilder sb = new StringBuilder();
		
		
		for (int t=0; t<m; t++) {
			st = new StringTokenizer(br.readLine());
			int i= Integer.parseInt(st.nextToken());
			int j= Integer.parseInt(st.nextToken());
			
					
			sb.append(accumulate[j]-accumulate[i-1]).append("\n");
		}
		System.out.println(sb);
		
	}

}
