import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int n = 0; n <= N; n++) {
			graph.add(new ArrayList<>());
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		
		for(int v = 1; v <= N; v++) {
			Collections.sort(graph.get(v));
		}
		
		// dfs
		Stack<Integer> dfsStack = new Stack<>();
		boolean[] visited = new boolean[N+1];
		
		dfsStack.add(V);
		while(!dfsStack.isEmpty()) {
			
			int v = dfsStack.pop();
			if(visited[v])
				continue;
			visited[v] = true;
			
			sb.append(v)
				.append(" ");
			
			Stack<Integer> tempStack = new Stack<>();
			for(int child : graph.get(v)) {
				if(visited[child] == true)
					continue;
				tempStack.add(child);
			}
			while(!tempStack.isEmpty()) {
				dfsStack.add(tempStack.pop());
			}
		}
		sb.append("\n");
		
		// bfs
		Queue<Integer> q = new LinkedList<Integer>();
		visited = new boolean[N+1];
		q.add(V);
		
		while(!q.isEmpty()) {
			int v = q.poll();
			if(visited[v])
				continue;
			visited[v] = true;
			sb.append(v)
				.append(" ");
			
			for(int child : graph.get(v)) {
				if(visited[child] == true)
					continue;
				q.add(child);
			}
		}
		
		
		System.out.println(sb);
	}

}