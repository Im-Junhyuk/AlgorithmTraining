import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int[] parent;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.dist-n2.dist);
			
			for(int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				pq.add(new Node(v1, v2, w));
			}
			
			int edgeCount = 0;
			long minDist = 0;
			parent = new int[V+1];
			for(int i = 1; i <= V; i++) {
				parent[i] = i;
			}
			
			while(edgeCount < V-1) {
				Node curNode = pq.poll();
				
				int v1 = curNode.v1;
				int v2 = curNode.v2;
				int dist = curNode.dist;
//				System.out.println(v1 + " " + v2 + " " + dist);
				int parent1 = find(v1);
				int parent2 = find(v2);
				if(parent1 == parent2)
					continue;
				
				union(parent1, parent2);
				
				minDist += dist;
				edgeCount++;
			}
			
			sb.append("#")
				.append(t)
				.append(" ")
				.append(minDist)
				.append("\n");
		}
		System.out.print(sb);
//		System.out.println(Arrays.toString(parent));
	}
	static class Node{
		int v1;
		int v2;
		int dist;
		Node(int v1, int v2, int dist){
			this.v1 = v1;
			this.v2 = v2;
			this.dist = dist;
		}
	}
	
	static int find(int v) {
		if(v == parent[v])
			return v;
		else
			return parent[v] = find(parent[v]);
	}
	
	static void union(int v1, int v2) {
		if(v1 < v2)
			parent[v2] = v1;
		else
			parent[v1] = v2;
	}
}
