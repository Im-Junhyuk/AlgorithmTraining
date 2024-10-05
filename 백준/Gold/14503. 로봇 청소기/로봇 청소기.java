import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cleaned = 0;
		
		while(true) {
			if(map[r][c] == 0) {
				map[r][c] = -1;
				cleaned++;
			}
			
			int nd = d;
			int nr = 0;
			int nc = 0;
			boolean cleanable = false;
			for(int i = 0; i < 4; i++) {
				nd = (nd+3) % 4;
				nr = r + dx[nd];
				nc = c + dy[nd];
				if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0) {
					cleanable = true;
					break;
				}
			}
			
			if(nd == d && cleanable == false) {
				r -= dx[d];
				c -= dy[d];
				if(map[r][c] == 1) {
					System.out.println(cleaned);
					return;
				}
			} else {
				d = nd;
				r = nr;
				c = nc;
			}
		}
	}
}
