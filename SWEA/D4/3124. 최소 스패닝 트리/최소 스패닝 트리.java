import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			ArrayList<Node>[] graph = new ArrayList[V+1];
			for(int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				graph[v1].add(new Node(v2, w));
				graph[v2].add(new Node(v1, w));
			}
			
			boolean[] visited = new boolean[V+1];
			PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.dist-n2.dist);
			for(Node n : graph[1]) {
				pq.add(n);
			}
			visited[1] = true;
			int nodeCount = 1;
			long minWeight = 0;
			
			while(!pq.isEmpty()) {
				Node curNode = pq.poll();
				if(nodeCount == V)
					break;
				if(visited[curNode.dest])
					continue;
				
				visited[curNode.dest] = true;
				minWeight += curNode.dist;
				
				for(Node n : graph[curNode.dest]) {
					if(visited[n.dest] == false)
						pq.add(n);
				}
				nodeCount++;
			}
			sb.append("#")
				.append(t)
				.append(" ")
				.append(minWeight)
				.append("\n");
		}
		System.out.println(sb);
	}
	static class Node{
		int dest;
		int dist;
		Node(int dest, int dist){
			this.dest = dest;
			this.dist = dist;
		}
	}
}
