import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] graph;
	static boolean[] visited;
	static int addicted;
	static int com;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		com = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(br.readLine());
		
		graph = new boolean[com+1][com+1];
		for(int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			graph[c1][c2] = true;
			graph[c2][c1] = true;
		}
		
		visited = new boolean[com+1];
		addicted = -1;
		dfs(1);
		System.out.println(addicted);

	}
	static void dfs(int c) {
		visited[c] = true;
		addicted++;
		
		for(int i = 1; i < com+1; i++) {
			if(graph[c][i] && !visited[i])
				dfs(i);
		}
	}
}
