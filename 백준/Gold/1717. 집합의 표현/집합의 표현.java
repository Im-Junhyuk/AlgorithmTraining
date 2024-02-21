import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] vertices;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int inst;
		int vertex1;
		int vertex2;
		vertices = new int[n+1];
		
		for(int i = 0; i <= n; i++)
			vertices[i] = i;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			inst = Integer.parseInt(st.nextToken());
			vertex1 = Integer.parseInt(st.nextToken());
			vertex2 = Integer.parseInt(st.nextToken());
			
			if (inst ==0) {	// union
				union(vertex1, vertex2);
				
			} else if (inst == 1) {	//find
				if(find(vertex1) == find(vertex2))
					System.out.println("yes");
				else 
					System.out.println("no");
			}
		}
	}
	
	static void union(int vertex1, int vertex2) {
		int v1Root = find(vertex1);
		int v2Root = find(vertex2);
		
			vertices[v1Root] = v2Root;
	}
	
	static int find(int vertex) {
		int v = vertex;

		if (v == vertices[v])
			return v;
		else 
			return vertices[v] = find(vertices[v]);
		
	}

}