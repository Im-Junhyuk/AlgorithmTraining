import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer. parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] parent = new int[N+1];
			for(int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine());
				int paren = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				parent[child] = paren;
			}
			
			int[] visited = new int[N+1];
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			int node = node1;
			
			while(node != 0) {
				visited[node] = 1;
				node = parent[node];
			}
			
			node = node2;
			while(node != 0) {
				if(visited[node] == 1) {
					break;
				}
				node = parent[node];
			}
			System.out.println(node);
			
		}
	}

}