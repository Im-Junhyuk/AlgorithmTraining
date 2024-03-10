import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		int[] indivisualCnt = new int[N];
		int cur = 0;
		indivisualCnt[cur]++;
		
		while(M > indivisualCnt[cur]) {
			if(indivisualCnt[cur] % 2 == 0) {
				cur = (cur+L)%N;
			} else {
				cur = (cur+L+N)%N;
			}
			indivisualCnt[cur]++;
			cnt++;
		}
		System.out.println(cnt);
	}
}