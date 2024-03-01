import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int black = 0;
	static boolean[][] paper;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		paper = new boolean[102][102];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = x; i < x + 10; i++) {
				for(int j = y; j < y + 10; j++) {
					paper[i][j] = true;
				}
			}
		}
		visited = new boolean[102][102];
		for(int i = 0; i < 102; i++) {
			for(int j = 0; j < 102; j++) {
				if(paper[i][j] == false && visited[i][j] == false)
					dfs(i, j);
			}
			
		}

		System.out.println(black);
	}
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static void dfs(int x, int y) {
//		System.out.println("2");
		visited[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int newX = x + dx[d];
			int newY = y + dy[d];
			
			if(newX >= 0 && newY >= 0 && newX < 102 && newY < 102) {
				if(paper[newX][newY]) {
					black++;
					continue;
				}
				if(visited[newX][newY] == false)
					dfs(newX, newY);
			}
		}
	}
}
