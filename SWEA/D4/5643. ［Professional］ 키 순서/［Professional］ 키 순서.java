import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] ancester;
	static int[] children;
	
	static boolean[] visited;
	
	static ArrayList<Integer>[] smalls;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			ancester = new int[N+1];
			children = new int[N+1];
			
			int[] biggerNum = new int[N+1];
			smalls = new ArrayList[N+1];
			
			for(int i = 1; i <= N; i++) {
				smalls[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int small = Integer.parseInt(st.nextToken());
				int big = Integer.parseInt(st.nextToken());
				
				biggerNum[small]++;
				smalls[big].add(small);
			}
			
			// topolygical sort
			Queue<Integer> q = new LinkedList<>();
			for(int i = 1; i <= N; i++) {
				if(biggerNum[i] == 0)
					q.add(i);
			}
			
			int result = 0;
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				visited = new boolean[N+1];
//				System.out.println(cur + " call");
				children[cur] = dfs(cur);
//				System.out.println();
				if(ancester[cur] + children[cur] -1 == N) {
					result++;
//					System.out.println(cur + " alone " + children[cur]);
				}
				
				for(int c : smalls[cur]) {
					biggerNum[c]--;
					if(biggerNum[c] == 0)
						q.add(c);
				}
			}
			
			sb.append("#")
				.append(tc)
				.append(" ")
				.append(result)
				.append("\n");
			
//			for(int i = 1; i <= N;i++) {
//			System.out.print(ancester[i] + " ");
//			}
//			System.out.println();
//			for(int i = 1; i <= N;i++) {
//			System.out.print(children[i] + " ");
//			}
//			System.out.println();
		}
		System.out.print(sb);
	}
	static int dfs(int v) {
		
		int result = 0;
//		System.out.print(v + " ");
		ancester[v]++;
		for(int c : smalls[v]) {
			if(visited[c])
				continue;
			visited[c] = true;
			result += dfs(c);
		}
		
		
		return result + 1;
		
	}

}
