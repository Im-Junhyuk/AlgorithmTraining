import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] graph;
	
	static int minW;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		graph = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		visited[0] = true;
		minW = Integer.MAX_VALUE;
		dfs(0, 1, 0);
	
		System.out.println(minW);
	}
	
	static void dfs(int v, int vNum, int curW) {
		
		for(int i = 0; i < N; i++) {
			if(visited[i] || graph[v][i] == 0)
				continue;
			
			visited[i] = true;
			dfs(i, vNum+1, curW + graph[v][i]);
			visited[i] = false;
		}
		
		
		if(vNum == N && graph[v][0] != 0) {

			int result = curW + graph[v][0];
			minW = Math.min(minW, result);
			return;
		}
	}
}
