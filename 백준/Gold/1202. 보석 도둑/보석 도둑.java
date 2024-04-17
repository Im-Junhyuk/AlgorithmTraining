import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
	
	static class Jewel implements Comparable<Jewel>{
		int weight;
		int value;
		
		Jewel(int weight, int value){
			this.weight = weight;
			this.value = value;
		}

		@Override
		public int compareTo(Jewel o) {
//			if(this.value != o.value)
				return o.value - this.value;
			
			
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Jewel> pq = new PriorityQueue<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();

		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			pq.add(new Jewel(m, v));
		}
		
		for(int k = 0; k < K; k++) {
			int bag = Integer.parseInt(br.readLine());
			if(map.containsKey(bag))
				map.replace(bag, map.get(bag)+1);
			else
				map.put(bag, 1);
		}
		
		long sum = 0;
		while(pq.size() > 0 && map.size() > 0) {
			Jewel cur = pq.poll();
			
			Integer bag = map.ceilingKey(cur.weight);
			
			if(bag != null) {
				int num = map.get(bag);
				if(num == 1)
					map.remove(bag);
				else
					map.replace(bag, num-1);
				
//				System.out.println(cur.weight);
				sum += cur.value;
			}
		}
		
		System.out.println(sum);
	}

}
