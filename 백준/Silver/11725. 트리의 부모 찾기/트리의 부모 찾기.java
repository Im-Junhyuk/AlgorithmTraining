import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
	static int[] parent;
	static int [] visited;
	static int N;
	static ArrayList<ArrayList<Integer>> edge;
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		edge = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			edge.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			edge.get(p1).add(p2);
			edge.get(p2).add(p1);

		}

		// root node is 1, with path, store parent
		parent = new int[N+1];
		visited = new int[N+1];
		
		findChild(1);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 2; i < N+1; i++) {
			bw.write(parent[i] + "\n");
		}
		bw.flush();
		
		
	}

	static public void findChild(int node) {
		if (visited[node] == 1)
			return;
		visited[node] = 1;
		for(int i : edge.get(node)) {
			if (visited[i] == 0) {
				parent[i] = node;
				findChild(i);
			}
		}
	}
}