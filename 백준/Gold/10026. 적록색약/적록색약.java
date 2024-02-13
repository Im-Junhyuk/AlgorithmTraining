import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	
	static boolean[][] visited;
	static char[][] picture;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		picture = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				picture[i][j] = str.charAt(j);
			}
		}
		int count = 0;
		int count2 = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == false) {
					count++;
					dfs(i, j);
				}
			}
		}
		
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(picture[i][j] == 'G')
					picture[i][j] = 'R';
			}
		}
		for(int i = 0;i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == false) {
					count2++;
					dfs(i, j);
				}
			}
		}
		
		System.out.println(count + " " + count2);
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nextX = dx[d] + x;
			int nextY = dy[d] + y;
			if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N 
					&& visited[nextX][nextY] == false && picture[nextX][nextY] == picture[x][y])
				dfs(nextX, nextY);
		}
	}

}