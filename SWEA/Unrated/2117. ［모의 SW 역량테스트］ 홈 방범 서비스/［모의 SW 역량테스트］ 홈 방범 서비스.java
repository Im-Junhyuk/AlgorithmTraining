import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int M;
	static boolean[][] map;
	static int[] cost;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// city length
			M = Integer.parseInt(st.nextToken());	// cost per house
			map = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					if(st.nextToken().equals("1"))
						map[i][j] = true;
				}
			}
			
			cost = new int[2*N];
			for(int i = 1; i < 2*N; i++) {
				cost[i] = i * i + (i-1) * (i-1);
			}
			
			int maxHouse = -1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// center
					maxHouse = Math.max(maxHouse, calculation(i, j));
				}
			}
			sb.append("#")	
				.append(t)
				.append(" ")
				.append(maxHouse)
				.append("\n");
		}
		
		System.out.println(sb);
	}
	static int calculation(int i, int j) {
		
		int maxHouse = -1;
		int house = 0;

		boolean[][] visited = new boolean[N][N];
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(i, j));
		visited[i][j] = true;
		
		for(int len = 1; len < 2*N; len++) {
			
			Queue<Point> newQ = new LinkedList<Point>();
			while(!q.isEmpty()) {
				Point p = q.poll();
				int x = p.x;
				int y = p.y;
				if(map[x][y])
					house++;
				
				for(int d = 0; d < 4; d++) {
					if(x+dx[d] >= 0 && x+dx[d] < N && y+dy[d] >= 0 && y+dy[d] < N
							&& visited[x+dx[d]][y+dy[d]] == false) {
						visited[x+dx[d]][y+dy[d]] = true;
						newQ.add(new Point(x+dx[d], y+dy[d]));
					}
				}
			}
			
			q = newQ;
			
			if(maxHouse < house)
				if(house * M - cost[len] >= 0)
					maxHouse = house;
		}
		return maxHouse;
	}
	static class Point{
		int x; 
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
}
