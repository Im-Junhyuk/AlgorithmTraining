import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception, IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		
		for(int i = 1; i <=N; i++) 
			graph[i] = new ArrayList<Integer>();
		int[] indegree = new int[N+1];
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph[v1].add(v2);
			indegree[v2]++;
		}
		
		// init
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) 
			if(indegree[i] == 0)
				pq.add(i);
		
		while(result.size() < N) {
			
			int v = pq.poll();
			for(int i : graph[v]) {
				indegree[i]--;
				if(indegree[i] == 0)
					pq.add(i);
			}
			
			result.add(v);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : result) {
			sb.append(i)
			.append(" ");
		}
		
		System.out.println(sb);
	}
}