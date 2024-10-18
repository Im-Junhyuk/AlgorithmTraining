import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] buildings = new int[N];
		int[] cnt = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int answer = 0;
		for(int i = 0; i < N; i++) {
			double angle = Double.MAX_VALUE * (-1);
			int cur = 0;
			
			for(int j = i+1; j < N; j++) {
				double newAngle = (buildings[j]-buildings[i]) / (double) (j-i);
				if(newAngle > angle) {
					cur++;
					angle = newAngle;
					cnt[j]++;
					
				}
			}
			answer = Math.max(answer, cur + cnt[i]);
		}
		
		System.out.println(answer);
	}
}