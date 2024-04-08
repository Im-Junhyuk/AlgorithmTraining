import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		char[][] map = new char[R][C];
		
		int[][] swans = new int[2][2];
		int swanCnt = 0;
		
		for(int r = 0; r < R; r++) {
			String str = br.readLine();
			
			for(int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c] == 'L') {
					swans[swanCnt][0] = r;
					swans[swanCnt][1] = c;
					swanCnt++;
				}
			}
		}
		
		int day = 0;
		Queue<Point> swanQ = new LinkedList<>();
		Queue<Point> iceQ = new LinkedList<>();
		Queue<Point> temp = new LinkedList<>();
		
		boolean[][] swanVisited = new boolean[R][C];
		boolean[][] iceVisited = new boolean[R][C];
		
		swanQ.add(new Point(swans[0][0], swans[0][1]));
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {

				if(map[r][c] != 'X' && iceVisited[r][c] == false) {
					temp.add(new Point(r, c));
					
					while(!temp.isEmpty()) {
						
						Point cur = temp.poll();
						if(iceVisited[cur.x][cur.y])
							continue;
						
						iceVisited[cur.x][cur.y] = true;
						for(int d = 0; d < 4; d++) {
							int nr = cur.x + dx[d];
							int nc = cur.y + dy[d];
							
							if(nr < 0 || nr >= R || nc < 0 || nc >= C || iceVisited[nr][nc])
								continue;
							if(map[nr][nc] == 'X') {
								iceQ.add(new Point(nr, nc));
								continue;
							}
							temp.add(new Point(nr, nc));
							
							
						}
					}
				}
			}
		}

		while(true) {
			// swan
			
			temp = new LinkedList<>();
			while(!swanQ.isEmpty()) {
				Point cur = swanQ.poll();
				int r = cur.x;
				int c = cur.y;
				if(swanVisited[r][c])
					continue;
				
				swanVisited[r][c] = true;
				
				if(r == swans[1][0] && c == swans[1][1]) {
					System.out.println(day);
					return;
				}
				
				for(int d = 0; d < 4; d++) {
					int nr = r + dx[d];
					int nc = c + dy[d];
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C || swanVisited[nr][nc])
						continue;
					
					if(map[nr][nc] != 'X')
						swanQ.add(new Point(nr, nc));
					
					if(map[nr][nc] == 'X')
						temp.add(new Point(nr, nc));
				}
				
			}
			swanQ = temp;
			
			// ice
			temp = new LinkedList<>();
			while(!iceQ.isEmpty()) {
				Point cur = iceQ.poll();
				int r = cur.x;
				int c = cur.y;
				
				if(iceVisited[r][c])
					continue;
				iceVisited[r][c] = true;
				map[r][c] = '.';
				
				for(int d = 0; d < 4; d++) {
					int nr = r + dx[d];
					int nc = c + dy[d];
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C || iceVisited[nr][nc])
						continue;
					
					if(map[nr][nc] == 'X')
						temp.add(new Point(nr, nc));
				}
			}
			iceQ = temp;
			
			day++;
		}
		
		
	}
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

