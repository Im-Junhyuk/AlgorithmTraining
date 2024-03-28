import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int R;
	static int C;
	
	static char[][] map;
	
	static int sx;
	static int sy;
	
	static int ex;
	static int ey;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		Queue<Node> flood = new LinkedList<>();
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'D') {
					ex = i;
					ey = j;
					map[i][j] = '.';
				}
				
				if(map[i][j] == 'S') {
					sx = i;
					sy = j;
					map[i][j] = '.';
				}
				if(map[i][j] == '*')
					flood.add(new Node(i, j, 0));
			}
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sx, sy, 0));
		boolean[][] visited = new boolean[R][C];
		
		while(!q.isEmpty()) {
			display();
			Queue<Node> temp = new LinkedList<>();
			while(!flood.isEmpty()) {
				Node cur = flood.poll();
				int x = cur.x;
				int y = cur.y;
				for(int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || ny < 0 || nx >= R || ny >= C)
						continue;
					if(map[nx][ny] == '.') {
						if(nx == ex && ny == ey)
							continue;
						temp.add(new Node(nx, ny, 0));
						map[nx][ny] = '*';
					}
				}
				
			}
			flood = temp;
			
			temp = new LinkedList<>();
			while(!q.isEmpty()) {
				Node cur = q.poll();
				int x = cur.x;
				int y = cur.y;
				int dist = cur.dist;
//				System.out.println(x + " " + y);
				if(visited[x][y])
					continue;
				visited[x][y] = true;
				
				
				if(x == ex && y == ey) {
					System.out.println(dist);
					return;
				}
				
				for(int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]
							|| map[nx][ny] == '*' || map[nx][ny] == 'X')
						continue;
					
					temp.add(new Node(nx, ny, dist+1));
				}
			}
			
			q = temp;
		}
		// flood
		System.out.println("KAKTUS");
		// move
	}
	
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
	
	static void display() {
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(map[i][j]+ " ");
//			}System.out.println();
//		}System.out.println();
	}
}