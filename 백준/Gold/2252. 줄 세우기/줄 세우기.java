import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int indegree[] = new int[N+1];
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		// 0 index will not be used
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph[v1].add(v2);
			indegree[v2]++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) 
				q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();		
		while(!q.isEmpty()) {
			int v = q.poll();
			sb.append(v)
			.append(" ");
			
			for(int i : graph[v]) {
				indegree[i]--;
				if(indegree[i] == 0)
					q.add(i);
			}
			
		}
		

		System.out.println(sb);
		
		
	}

}