import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] solution = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}
		
		int front = 0;
		int end = N-1;
		
		int minAbs = Integer.MAX_VALUE;
		int s1 = solution[front];
		int s2 = solution[end];
		
		while(front != end) {
			int cur = solution[front] + solution[end];
			if(minAbs > Math.abs(cur)) {
				s1 = solution[front];
				s2 = solution[end];
				minAbs = Math.abs(cur);
			}
			if(cur > 0)
				end--;
			else if(cur < 0)
				front++;
			else 
				break;
		}
		System.out.println(s1 + " " + s2);
		
	}
}

