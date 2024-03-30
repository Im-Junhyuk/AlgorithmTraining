import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;
	
	static int rx;
	static int ry;
	static int rl=2;
	static int killCnt = 0;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					rx = i;
					ry = j;
					map[i][j] = 0;
				}
			}
		}
		
		int time = 0;
		while(true) {
			int ex = Integer.MAX_VALUE;
			int ey = Integer.MAX_VALUE;
			int ed = Integer.MAX_VALUE;
			
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(rx, ry, 0));
			boolean[][] visited = new boolean[N][N];
			
			while(!q.isEmpty()) {
				Node cur = q.poll();
				
				int x = cur.x;
				int y = cur.y;
				int dist = cur.dist;
//				System.out.println("x" + x + " y " + y + " " + dist + "dist " + map[x][y]);
				if(dist > ed)
					break;
				
				if(visited[x][y])
					continue;
				visited[x][y] = true;
				
				if(map[x][y] > 0) {
					if(rl > map[x][y]) {
						if(dist < ed) {
							ed = dist;
							ex = x;
							ey = y;
						} else if(dist == ed) {
							if(x < ex) {
								ex = x;
								ey = y;
							} else if( x == ex && y < ey) {
								ey = y;
							}
								
						}
					}
				}
				
				for(int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N 
							|| visited[nx][ny] == true || map[nx][ny] > rl)
						continue;
					q.add(new Node(nx, ny, dist+1));
				}
			
			}
			
//			System.out.println(ex + " " + ey + " " + ed);
			if(ed == Integer.MAX_VALUE)
				break;
			
			killCnt++;
			if(killCnt == rl) {
				killCnt = 0;
				rl++;
			}
			time += ed;
			rx = ex;
			ry = ey;
			map[rx][ry] = 0;
//			System.out.println(rx + " "+ ry);
//			System.out.println("time " + time + " kill " + killCnt);
		}
		
		System.out.println(time);
    }		
	
//	static boolean search() {
//		
//		
//	}
	static class Node{
		int x;
		int y;
		int dist;
		Node(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}