import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	
	static int[] parent;
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> graph; 

	
	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int n = 0; n < N-1; n++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		
		visited = new boolean[N+1];
		findParent(1);
		
		int M = Integer.parseInt(br.readLine());
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			sb.append(findAncestor(v1, v2))
				.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void findParent(int v) {
		if(visited[v])
			return;
		
		visited[v] = true;
		for(int c : graph.get(v)) {
			if(visited[c])
				continue;
			
			parent[c] = v;
			findParent(c);
		}
	}
	
	static int findAncestor(int v1, int v2) {
			visited = new boolean[N+1];

			while(v1 != 0) {
				visited[v1] = true;
				v1 = parent[v1];
			}
			
			while(v2 != 0) {
				if(visited[v2])
					return v2;
				v2 = parent[v2];
			}
			
			return 1;
	}
}
