import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main{

	static boolean[] visited;
	static int cnt = 0;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] color;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		color = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 1; n <= N; n++) {
			color[n] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList<>();
		for(int n = 0; n <= N; n++) {
			graph.add(new ArrayList<>());
		}
		for(int n = 1; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}
		
		visited = new boolean[N+1];
		if(color[1] != color[0])
			cnt++;
		recurrsion(1);
		System.out.println(cnt);
		
	}
	static void recurrsion(int node) {

		visited[node] = true;
		
		for(int child : graph.get(node)) {
			if(visited[child])
				continue;
			if(color[child] != color[node])
				cnt++;
			recurrsion(child);
		}
	}
}
