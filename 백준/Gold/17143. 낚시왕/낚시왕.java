import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 상 우 하 좌
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static Shark[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R][C];
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			int d;
			if(D == 1)
				d = 0;
			else if(D == 2)
				d = 2;
			else if(D == 3)
				d = 1;
			else 
				d = 3;
			
			if(d == 1 || d == 3)
				s = s % (2*C-2);
			else
				s = s % (2*R-2);
			
			map[r-1][c-1] = new Shark(s, d, z);
		}
		
		int totalSize = 0;
		int fisher = 0;
		
		while(fisher < C) {
			
			for(int r = 0; r < R; r++) {
				if(map[r][fisher] == null)
					continue;
				else {
					totalSize += map[r][fisher].z;
					map[r][fisher] = null;
					break;
				}
			}
			
			// move
			Shark[][] newMap = new Shark[R][C];
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					
					if(map[r][c] != null) {
						
						Shark s = map[r][c];
						int curR = r;
						int curC = c;
						
						int dr = dx[s.d];
						int dc = dy[s.d];
						
						for(int k = 0; k < s.s; k++) {

							if(curR+dr < 0 || curR+dr >= R || curC+dc < 0|| curC+dc >= C) {
								s.d = (s.d+2)%4;
								dr = -dr;
								dc = -dc;
							}
							
							curR += dr;
							curC += dc;	

						}
						
						if(newMap[curR][curC] == null || newMap[curR][curC].z < s.z) 
							newMap[curR][curC] = s;
					}
				}
			}
			fisher++;
			map = newMap;
			
		}
		System.out.println(totalSize);
	}
	static class Shark{
		int s;
		int d;
		int z;
		Shark(int s, int d, int z){
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}

