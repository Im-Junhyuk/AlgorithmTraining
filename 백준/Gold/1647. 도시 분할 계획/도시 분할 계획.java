import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parents;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
		parents = new int[N+1];
		for(int n = 0; n < N+1; n++) {
			parents[n] = n;
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(v1, v2, w));
		}
		
		int connedted = 0;
		int totalLength = 0;
		int maxlength = 0;
		
		while(connedted < N-1) {
			Edge e = edges.poll();
			int v1 = e.v1;
			int v2 = e.v2;
			int w = e.weight;
			
			int p1 = find(v1);
			int p2 = find(v2);
			if(p1 != p2) {
				union(p1, p2);
				totalLength += w;
				maxlength = Math.max(maxlength, w);
				connedted++;
			}
		}
		System.out.println(totalLength - maxlength);
	}
	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int weight;
		Edge(int v1, int v2, int weight){
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static void union(int v1, int v2) {
		if(v1 <= v2)
			parents[v2] = v1;
		else 
			parents[v1] = v2;
	}
	
	static int find(int v) {
		if(v == parents[v])
			return v;
		else 
			return parents[v] = find(parents[v]);
	}
}
