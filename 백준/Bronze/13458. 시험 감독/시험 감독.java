import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[] people = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int jang = Integer.parseInt(st.nextToken());
		int won = Integer.parseInt(st.nextToken());
		long num = 0;
		for(int i = 0; i < n; i++) {
			int cur = people[i];
			cur -= jang;
			num++;
			if(cur < 0)
				cur = 0;
			num += cur / won;
			if(cur % won != 0)
				num++;
		}
		
		System.out.println(num);
	}
}