import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] resultGraph;
	static int[] visited;
	static Queue<Edge> q;
	static ArrayList<Edge>[] graph;
	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Main.Edge>();
		}
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph[v1].add(new Edge(v2, 1));
			graph[v2].add(new Edge(v1, 1));
		}
		
		resultGraph = new int[N+1][N+1];
		for(int p = 1; p <= N; p++) {
			q = new LinkedList<Main.Edge>();
			visited = new int[N+1];
			visited[p] = 1;
			for(Edge e : graph[p]) {
				q.add(e);
			}
			bfs(p);
		}
		
		int result[] = new int[N+1];
		for(int i = 1; i <=N; i++) {
			for(int j = 1; j <= N; j++) {
				result[i] += resultGraph[i][j];
			}
		}
		int min = Integer.MAX_VALUE;
		int minPerson = 0;
		for(int i = 1; i <= N; i++) {
			if(result[i] < min) {
				min = result[i];
				minPerson = i;
			}
		}
		
		System.out.println(minPerson);
	}
	static class Edge{
		int dest;
		int dist;
		
		Edge(int dest, int dist){
			this.dest = dest;
			this.dist = dist;
		}
	}
	
	static void bfs(int start) {
		
		while(!q.isEmpty()) {
			Edge curV = q.poll();
		
			if(visited[curV.dest] == 1)
				continue;
			
			visited[curV.dest] = 1;
			
			resultGraph[start][curV.dest] = curV.dist;
			for(Edge e : graph[curV.dest]) {
				q.add(new Edge(e.dest, curV.dist+e.dist));
			}
		}

	}
}