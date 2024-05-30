import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		if(N <= K) {
			System.out.println(0);
			return;
		}
		
		st = new StringTokenizer(br.readLine());
		
		int[] sensors = new int[N];
		for(int i = 0; i < N; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensors);
		
		int total_dist = sensors[N-1] - sensors[0];
		
		if(K == 1) {
			System.out.println(total_dist);
			return;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 1; i <= N-1; i++) {
			
			int cur = sensors[i] - sensors[i-1];
			
			if(pq.size() < K-1) {
				
				pq.add(cur);
				
			} else {
				
				if(cur > pq.peek()) {
					
					pq.poll();
					pq.add(cur);
				}
			}
		}
		
		int empty = 0;
		while(!pq.isEmpty()) {
			empty += pq.poll();
		}

		System.out.println(total_dist - empty);
    }
}
