import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{


	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[n+1][n+1];
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < n+1; j++) {
				if(i == j)
					graph[i][j] = 0;
				else
					graph[i][j] = Integer.MAX_VALUE;
				
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[start][end] = Math.min(graph[start][end], weight);
		}
		
		for(int mid = 1; mid < n+1; mid++) {
			for(int start = 1; start < n+1; start++) {
				for(int end = 1; end < n+1; end++) {
					if(graph[start][mid] != Integer.MAX_VALUE
							&& graph[mid][end] != Integer.MAX_VALUE)
					graph[start][end] = Math.min(graph[start][end], 
							graph[start][mid] + graph[mid][end]);
				}
			}
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(graph[i][j] == Integer.MAX_VALUE)
					sb.append(0)
						.append(" ");
				else
					sb.append(graph[i][j])
						.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}