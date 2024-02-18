import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arrivalTime = new int[100002];
		for(int i = 0; i < arrivalTime.length-1; i++) {
			arrivalTime[i] = Integer.MAX_VALUE;
		}
		int count = 0;
		
		Queue<Subin> q = new LinkedList<Subin>();
		q.add(new Subin(N, 0));
		
		while(!q.isEmpty()) {
			Subin cur = q.poll();
			
			if(cur.time > arrivalTime[cur.location])
				continue;
			
			arrivalTime[cur.location] = cur.time;
			if(cur.location == K) {
				count++;
				continue;
			}
			
			if(cur.location - 1 >= 0 && cur.time+1 <= arrivalTime[cur.location-1])
				q.add(new Subin(cur.location-1, cur.time+1));
			if(cur.location + 1 <= 100001 && cur.time+1 <= arrivalTime[cur.location+1])
				q.add(new Subin(cur.location+1, cur.time+1));
			if(cur.location * 2 <= 100001 && cur.time+1 <= arrivalTime[cur.location*2])
				q.add(new Subin(cur.location*2, cur.time+1));
		}
		
		sb.append(arrivalTime[K])
			.append("\n")
			.append(count);
		
		System.out.println(sb);
//		for(int i = 0; i < 20; i++)
//			System.out.print(arrivalTime[i] + " ");
	}
	static class Subin{
		int location;
		int time;
		
		Subin(int locaion, int time){
			this.location = locaion;
			this.time = time;
		}
	}
}
