import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		ArrayList<Edge>[] edge = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			edge[i] = new ArrayList<Edge>();
		}
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edge[u].add(new Edge(v, w));
		}
		
		int[] distance = new int[V+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<Main.Edge>((e1, e2) -> e1.dist - e2.dist);
		for(Edge e : edge[K]) {
			pq.add(e);
		}

		int[] visited = new int[V+1];
		visited[K] = 1;
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if(visited[e.dest] == 1)
				continue;
			
			visited[e.dest] = 1;
			
			distance[e.dest] = e.dist;
			for(Edge next : edge[e.dest]) {
				pq.add(new Edge(next.dest, next.dist + e.dist));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(visited[i] == 0)
				sb.append("INF")
				.append("\n");
			else 
				sb.append(distance[i])
				.append("\n");
		}
		
		System.out.println(sb);
	}
	static class Edge{
		int dest;
		int dist;
		
		Edge(int dest, int dist){
			this.dest = dest;
			this.dist = dist;
		}
	}
}