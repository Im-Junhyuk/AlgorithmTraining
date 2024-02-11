import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Edge[] edge = new Edge[M];
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			edge[m] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		long[] dist = new long[N+1];
		for(int i = 2; i < N+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int v = 0; v < N-1; v++) {
			for(int e = 0; e < M; e++) {
				int start = edge[e].start;
				int end = edge[e].end;
				int weight = edge[e].weight;
				
				if(dist[start] == Integer.MAX_VALUE)
					continue;
				
				dist[end] = Math.min(dist[end], dist[start] + weight);
			}
		}
		
		for(int e = 0; e < M; e++) {
			int start = edge[e].start;
			int end = edge[e].end;
			int weight = edge[e].weight;
			
			if(dist[start] == Integer.MAX_VALUE)
				continue;
			
			if(dist[end] > dist[start] + weight) {
				System.out.println("-1");
				return;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i < N+1; i++) {
			if(dist[i] == Integer.MAX_VALUE) 
				sb.append("-1")
				.append("\n");
			else
				sb.append(dist[i])
				.append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	static class Edge{
		int start;
		int end;
		int weight;
		Edge(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
}