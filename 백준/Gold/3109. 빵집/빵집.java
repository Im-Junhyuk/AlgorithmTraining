import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static char[][] map;
	
	static int maxPipe = 0;
	static int pipe = 0;
	
	static boolean connected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int r = 0; r < R; r++) {
			String str = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		for(int r = 0; r < R; r++) {
			connected = false;
			steal(r, 0);
		}
		
		System.out.println(pipe);
	}
	
	static void steal(int row, int col) {

		if(row >= 0 && row < R && map[row][col] == '.') {
			map[row][col] = 'p';
			if(col == C-1) {
				pipe++;
				connected = true;
				return;
			}
		
			
			if(row >0 && connected == false)
				steal(row-1, col+1);
			if(!connected)
				steal(row, col+1);
			if(row <R-1 && !connected)
				steal(row+1, col+1);
		}
	}
}