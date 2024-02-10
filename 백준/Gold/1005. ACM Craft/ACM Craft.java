import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception, IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // number of building
			int K = Integer.parseInt(st.nextToken()); // number of rules
			
			int[] constructionTime = new int[N+1];
			st = new StringTokenizer(br.readLine());
			
			for(int n = 1; n <= N; n++) {
				constructionTime[n] = Integer.parseInt(st.nextToken());
			}
			
			ArrayList<Integer>[] graph = new ArrayList[N+1];
			for(int n = 1; n <= N; n++)
				graph[n] = new ArrayList<Integer>();
			int[] indegree = new int[N+1];
			int[] constructedTime = new int[N+1];
			Queue<Integer> q = new LinkedList<>();
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				
				graph[v1].add(v2);
				indegree[v2]++;
			}
			
			int W = Integer.parseInt(br.readLine());
			
			for(int n = 1; n <= N; n++) {
				if(indegree[n] == 0) {
					q.add(n);
					constructedTime[n] = constructionTime[n];
				}
			}
			
			while(!q.isEmpty()) {
				int v = q.poll();
				
				if(v == W) {
					sb.append(constructedTime[v])
					.append("\n");
					break;
				}
				
				for(int i : graph[v]) {
					constructedTime[i] = Math.max(constructedTime[i], constructedTime[v]+constructionTime[i]);
					indegree[i]--;
					if(indegree[i] == 0)
						q.add(i);
				}
			}
		}
		
		System.out.println(sb);
		
	}
}