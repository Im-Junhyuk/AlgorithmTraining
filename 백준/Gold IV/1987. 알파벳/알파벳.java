import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
	
	static int R;
	static int C;

	static int maxVisited = Integer.MIN_VALUE;
	static Set<Character> visited;
	static char[][] board;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][];
		for(int r = 0; r < R; r++) {
			board[r] = br.readLine().toCharArray();
		}
		
		visited = new HashSet<>();
		
		dfs(0, 0, 0);
		
		System.out.println(maxVisited);
	}
	
	static void dfs(int x, int y, int curVisited) {
		// visit
		curVisited++;
		visited.add(board[x][y]);
		
		// check 4 direction
		for(int d = 0; d < 4; d++) {
			int nextX = x + dx[d];
			int nextY = y + dy[d];
			if(nextX >= 0 && nextY >= 0 && nextX < R && nextY < C 
					&& !visited.contains(board[nextX][nextY]))
				dfs(nextX, nextY, curVisited);
		}
		
		// no way to go, update, return
		maxVisited = Math.max(maxVisited, curVisited);
		visited.remove(board[x][y]);
	}
}
