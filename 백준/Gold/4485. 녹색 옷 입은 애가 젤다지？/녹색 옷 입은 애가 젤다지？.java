import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
			
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			PriorityQueue<Point> pq = new PriorityQueue<>();
			pq.add(new Point(0, 0, map[0][0]));
			boolean[][] visited = new boolean[N][N];
			
			while(!pq.isEmpty()) {
				Point cur = pq.poll();
				int x = cur.x;
				int y = cur.y;
				if(x == N-1 && y == N-1){
					sb.append("Problem ")
						.append(t)
						.append(": ")
						.append(cur.dist)
						.append("\n");
					break;
				}
				if(visited[x][y])
					continue;
				
				visited[x][y] = true;
				
				for(int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx >= 0 && ny >= 0 && nx < N && ny < N 
							&& visited[nx][ny] == false)
						pq.add(new Point(nx, ny, cur.dist+ map[nx][ny]));
				}
			}
			t++;
		}
		
		System.out.println(sb);
	}
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int dist;
		Point(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
			
		}
		@Override
		public int compareTo(Point o) {
			return this.dist-o.dist;
		}
	}
}
