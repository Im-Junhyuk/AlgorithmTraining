import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int subTree;
	static ArrayList<ArrayList<Integer>> tree;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			tree = new ArrayList<ArrayList<Integer>>();
			int[] parent = new int[V+1];
			for(int i = 0; i < V+1; i++) {
				tree.add(new ArrayList<Integer>());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int e = 0; e < E; e++) {
				int paren = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parent[child] = paren;
				tree.get(paren).add(child);
			}
			
			int[] visited = new int[V+1];
			
			int curV = v1;
			while(true) {
				curV = parent[curV];
				visited[curV] = 1;
				if(curV == 1) 
					break;
			}
			
			curV = v2;
			int lca;
			while(true) {
				curV = parent[curV];
				if(visited[curV] == 1) {
					lca = curV;
					break;
				}
			}
			subTree = 0;
			System.out.print("#" + tc + " " + lca + " ");
			findChild(lca);
			System.out.println(subTree);
			
		}
	}
	
	static void findChild(int v) {
		subTree++;
		for(int child : tree.get(v)) {
			findChild(child);
		}
	}
}