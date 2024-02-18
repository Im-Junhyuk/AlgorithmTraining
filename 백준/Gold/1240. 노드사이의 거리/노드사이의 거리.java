import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Integer>> graph;
	static int[][] distance;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		distance = new int[N+1][N+1];
		
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
			distance[v1][v2] = dist;
			distance[v2][v1] = dist;
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			visited = new boolean[N+1];
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(v1, 0));
			
			while(!q.isEmpty()) {
				Node cur = q.poll();
				
				if(cur.v == v2)
					sb.append(cur.dist)
						.append("\n");
				visited[cur.v] = true;
				for(int i : graph.get(cur.v)) {
					if(visited[i])
						continue;
					q.add(new Node(i, cur.dist + distance[cur.v][i]));
				}
			}
		}
		System.out.println(sb);
	}
	static class Node{
		int v;
		int dist;
		Node(int v, int dist){
			this.v = v;
			this.dist = dist;
		}
	}
}