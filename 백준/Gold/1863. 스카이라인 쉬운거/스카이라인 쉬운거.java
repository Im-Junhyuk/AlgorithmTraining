import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int cur = 0;
		int count = 0;
		PriorityQueue<Integer> candidate = new PriorityQueue<Integer>(Comparator.reverseOrder());
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(y > cur) {
				count++;
				candidate.add(cur);
				cur = y;
			}
			
			if(y < cur) {
				while(candidate.peek() > y) {
					candidate.poll();
				}
				
				if(candidate.peek() == y) {
					candidate.poll();
				} else {
					count++;
				}
				cur = y;
			}
		}
		System.out.println(count);
	}
}