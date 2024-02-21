import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;
		
		graph = new ArrayList<>();
		for(int n = 0; n < N; n++) {
			graph.add(new ArrayList<>());
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			graph.get(p1).add(p2);
			graph.get(p2).add(p1);
		}
		
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			if(dfs(i, 1) >= 4) {
				result = 1;
				break;
			}
		}
		System.out.println(result);
	}
	
	static int dfs(int p, int count) {
		if(count == 5)
			return 5;
		visited[p] = true;
		
		for(int f : graph.get(p)) {
			if(visited[f] == false) {
				if(dfs(f, count+1) == 5)
					return 5;
				else
					visited[f] = false;
			}
		}
		
		return 0;
	}
}