import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		result = new int[m];
		
		perm(1, 0);
		
	}
	
	public static void perm(int start, int cnt) {
		if (cnt == m) {
			for (int i: result)
				System.out.printf("%d ", i);
			System.out.println();
			return;
		}
		
		for (int i=start; i<n+1; i++) {
			if (!(visited[i])) {
				result[cnt] = i;
				visited[i] = true;
				perm(i+1, cnt+1);
				visited[i] = false;
				
			}
		}
		
		
	}

}
