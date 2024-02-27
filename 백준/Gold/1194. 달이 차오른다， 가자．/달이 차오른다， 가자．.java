import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	
	static char[][] maze;
	static boolean[][][] visited;
	
	static int minMove;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new char[N][M];
		Point sp = null;
		
		visited = new boolean[N][M][64];
		
		for(int n = 0; n < N; n++) {
			String str = br.readLine();
			for(int m = 0; m < M; m++) {
				maze[n][m] = str.charAt(m);
				
				if(maze[n][m] == '0')
					sp = new Point(n, m);
			}
		}
	
		System.out.println(bfs(sp));
	}
	static class Point{
		int x;
		int y;
		int keySet;
		int move;
		Point(int x, int y){
			this.x = x;
			this.y = y;
			this.keySet = 0;
			this.move = 0;
		}
		
		Point(int x, int y, int keySet, int move){
			this.x = x;
			this.y = y;
			this.keySet = keySet;
			this.move = move;
		}
	}
	
	static int bfs(Point sp) {
		Queue<Point> q = new LinkedList<>();
		
		q.add(sp);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(maze[p.x][p.y] == '1') {
				return p.move;
			}
				
			if(visited[p.x][p.y][p.keySet])
				continue;
			
			visited[p.x][p.y][p.keySet] = true;
//			System.out.println(p.keySet);
//			System.out.println(p.x + " " + p.y);
			int keyNum = maze[p.x][p.y] - 'a';
			if(0 <= keyNum && keyNum < 6) {
				int key = (1 << keyNum);
				p.keySet = p.keySet | key;
			}
				
			
			for(int d = 0; d < 4; d++) {
				int nextX = p.x + dx[d];
				int nextY = p.y + dy[d];
				
				if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M 
						&& visited[nextX][nextY][p.keySet] == false && maze[nextX][nextY] != '#') {
					// if there is a gate
					int gate = maze[nextX][nextY] -'A';
//					System.out.println("gate " + gate);
					if(0 <= gate && gate < 6) {
						if((1 << gate) != (p.keySet & (1 << gate)))
							continue;
					}
					q.add(new Point(nextX, nextY, p.keySet, p.move+1));
				}
			}
			
			
		}
		
		return -1;
	}

}
