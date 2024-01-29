import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int [][] board;

	public static void main(String[] args) throws Exception {

		//여기에 코드를 작성하세요.
		
		board = new int[19][19];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// check
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(board[i][j] != 0)
					if(isWin(i, j) == true) {
						bw.write(board[i++][j++] + "\n");
						bw.write(i + " " + j );
						bw.flush();
						return;
					}
			}
		}
		
		bw.write(0 + "");
		bw.flush();
	}
	public static boolean isWin(int i, int j) {
		int[] dx = {1, 0, -1, 1};
		int[] dy = {1, 1, 1, 0};
		
		for(int d = 0; d < dx.length; d++) {
			int x = i;
			int y = j;
			boolean wasBreak = false;
			
			if(x - dx[d] >= 0 && x -dx[d] < 19 && y - dy[d] >= 0 && y - dy[d] <19)
					if( board[x - dx[d]][y - dy[d]] == board[x][y])
						continue;
			
			for(int k = 0; k < 4; k++) {
				x += dx[d];
				y += dy[d];
				
//				if(x >= 0 && x < 19 && y >= 0 & y <19) {
//					if (board[x][y] == board[i][j]) {
//						continue;
//					}	else {
//						wasBreak = true;
//						break;
//					}	
//				} else {
//					wasBreak = true;
//					break;
//				}
			
				
				if (x < 0 || x >= 19 || y < 0 || y >= 19 || board[x][y] != board[i][j]) {
					wasBreak = true;
					break;
				} 
				
			}
			
			x += dx[d];
			y += dy[d];
			if(x >= 0 && x < 19 && y >= 0 && y<19) {
				if(board[x][y] == board[i][j])
				wasBreak = true;
			}
			if(wasBreak == false)
				return true;
		}
		return false;
		
	}
}
