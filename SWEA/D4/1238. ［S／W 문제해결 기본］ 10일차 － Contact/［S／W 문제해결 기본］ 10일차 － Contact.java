import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc < 11; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int dataLen = Integer.parseInt(st.nextToken());
			int sp = Integer.parseInt(st.nextToken());
			
			boolean[][] graph = new boolean[101][101];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < dataLen/2; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				graph[s][e] = true;
			}
			
			boolean[] visited = new boolean[101];
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(sp);
			ArrayList<Integer> previousOnes = null;
			
			while(!q.isEmpty()) {
				
				Queue<Integer> tempQ = new LinkedList<>();
				previousOnes = new ArrayList<>();
				
				while(!q.isEmpty()) {
					int cur = q.poll();
					if(visited[cur])
						continue;
					visited[cur] = true;
					previousOnes.add(cur);
					
					for(int i = 1; i < 101; i++) {
						if(graph[cur][i] == true && visited[i] == false)
							tempQ.add(i);
					}
				}
				q = tempQ;
			}
			sb.append("#")
				.append(tc)
				.append(" ")
				.append(Collections.max(previousOnes))
				.append("\n");
			
		}
		System.out.println(sb);
	}

}