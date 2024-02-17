import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] parents;
	static ArrayList<Integer>[] children;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		parents = new ArrayList[N+1];
		children = new ArrayList[N+1];
		
		for(int i = 0; i < N+1; i++) {
			parents[i] = new ArrayList<>();
			children[i] = new ArrayList<>();
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			parents[child].add(parent);
			children[parent].add(child);
		}
		
		visited = new boolean[N+1];
		
		sb.append(parentDFS(X))
			.append(" ");
		visited = new boolean[N+1];
		sb.append(N - childDFS(X) + 1);
		
		System.out.println(sb);
	}
	
	static int parentDFS(int cur) {

		int parentNum = 1;
		
		for(int p : parents[cur]) {
			if(visited[p])
				continue;
			
			visited[p] = true;
			parentNum += parentDFS(p);
		}
		return parentNum;
	}
	
	static int childDFS(int cur) {

		int childNum = 1;
		
		for(int c : children[cur]) {
			if(visited[c])
				continue;
			
			visited[c] = true;
			childNum += childDFS(c);
		}
		return childNum;
	}
}
