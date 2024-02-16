import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	

	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>((i1, i2) -> (i2 - i1));
		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
		
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine());
			
			if(maxPQ.size() == 0) {
				maxPQ.add(num);
			} else if(num >= maxPQ.peek()) {
				minPQ.add(num);
			} else {
				maxPQ.add(num);
			}
			
			if(maxPQ.size() == minPQ.size() + 2)
				minPQ.add(maxPQ.poll());
			
			if(maxPQ.size() < minPQ.size())
				maxPQ.add(minPQ.poll());

			sb.append(maxPQ.peek())
				.append("\n");
		}
		System.out.println(sb);
	}
}
