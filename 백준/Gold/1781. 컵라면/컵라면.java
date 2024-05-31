import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		Hw[] hws = new Hw[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int deadline = Integer.parseInt(st.nextToken());
			int reward = Integer.parseInt(st.nextToken());
			hws[i] = new Hw(deadline, reward);
		}
		
		Arrays.sort(hws, (h1, h2 ) -> h1.deadline - h2.deadline);
		int dayNum = hws[N-1].deadline;
		int cur = N-1;
		PriorityQueue<Hw> pq = new PriorityQueue<Main.Hw>();
		int totalReward = 0;
		
		while(dayNum > 0) {
			while(cur >= 0 && dayNum == hws[cur].deadline) {
				pq.add(hws[cur]);
				cur--;
			}
			
			if(!pq.isEmpty()) {
				totalReward += pq.poll().reward;
//				System.out.println(dayNum + " " + totalReward);
			}
			
			dayNum--;
		}
		
		System.out.println(totalReward);
	}
	
	static class Hw implements Comparable<Hw>{
		int deadline;
		int reward;
		
		Hw(int deadline, int reward){
			this.deadline = deadline;
			this.reward = reward;
		}

		@Override
		public int compareTo(Main.Hw o) {
			return o.reward - this.reward;
		}
	}
}