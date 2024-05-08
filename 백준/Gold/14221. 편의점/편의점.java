import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] isHouse;
	static boolean[] isConv;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		
		for(int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(new Node(v2, d));
			graph.get(v2).add(new Node(v1, d));
		}
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		isHouse = new boolean[n+1];
		for(int i = 0; i < p; i++) {
			int num = Integer.parseInt(st.nextToken());
			isHouse[num] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		isConv = new boolean[n+1];
		for(int i = 0; i < q; i++) {
			int num = Integer.parseInt(st.nextToken());
			isConv[num] = true;
		}
		
		
		PriorityQueue<Node> pq = new PriorityQueue<Main.Node>();
		for(int i = 1; i < n+1; i++) {
			if(isConv[i] == false)
				continue;
			
			for(Node node : graph.get(i)) {
				if(isConv[node.dest])
					continue;
				
				pq.add(node);
			}
		}
		
		boolean[] visited = new boolean[n+1];
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(isHouse[cur.dest]) {
				System.out.println(cur.dest);
				return;
			}
			if(visited[cur.dest])
				continue;
			
			visited[cur.dest] = true;
			
			for(Node node : graph.get(cur.dest)) {
				if(visited[node.dest])
					continue;
				if(isConv[node.dest])
					continue;
				
				pq.add(new Node(node.dest, cur.dist+node.dist));
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int dest;
		int dist;
		@Override
		public int compareTo(Main.Node o) {
			if(this.dist != o.dist)
				return this.dist - o.dist;
			return this.dest - o.dest;
		}
		
		public Node(int dest, int dist) {
			this.dest = dest;
			this.dist = dist;
		}
	}
}