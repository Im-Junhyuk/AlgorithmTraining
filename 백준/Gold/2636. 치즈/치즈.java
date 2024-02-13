import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int meltingCheeseNum = 0;
	static int[][] board; 
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static int row;
	static int col;
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		board = new int[row][col];

		
		for(int r = 0; r < row; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < col; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int preMeltingCheeseNum = 0;
		for(int i = 1; i < 101; i++) {
			visited = new boolean[row][col];
			dfs(0, 0);
			if(meltingCheeseNum == 0) {
				System.out.println(i-1);
				System.out.println(preMeltingCheeseNum);
				return;
			} else {
				preMeltingCheeseNum = meltingCheeseNum;
				meltingCheeseNum = 0;
			}
		}
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		if(board[x][y] == 1) {
			meltingCheeseNum++;
			board[x][y] = 0;
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int newX = dx[d] + x;
			int newY = dy[d] + y;
			if(newX >= 0 && newX < row && newY >= 0 && newY < col
					&& visited[newX][newY] == false)
				dfs(newX, newY);
		}
	}

}