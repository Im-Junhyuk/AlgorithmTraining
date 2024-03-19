import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int d;
		int mirror;
		
		Node(int x, int y, int d, int mirror){
			this.x = x;
			this.y = y;
			this.d = d;
			this.mirror = mirror;
		}

		@Override
		public int compareTo(Node o) {
			return this.mirror - (o).mirror;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[H][W];
		
		int pointCnt = 0;
		int[][] point = new int[2][2];
		for(int i = 0; i < H; i++) {
			String str = br.readLine();
			for(int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'C') {
					map[i][j] = '.';
					point[pointCnt][0] = i;
					point[pointCnt][1] = j;
					pointCnt++;
				}
			}
		}
		
		boolean[][][] visited = new boolean[H][W][5];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(point[0][0], point[0][1], 4, -1));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int x = cur.x;
			int y = cur.y;
			int d = cur.d;
			int mirror = cur.mirror;
							
			if(visited[x][y][cur.d])
				continue;
			
			if(x == point[1][0] && y == point[1][1]) {
				System.out.println(mirror);
				return;
			}
			
			visited[x][y][d] = true;
			
			for(int nd = 0; nd < 4; nd++) {
				int nx = x + dx[nd];
				int ny = y + dy[nd];
				
				if(nx >= 0 && nx < H && ny >= 0 && ny < W 
						&& map[nx][ny] == '.'
						&& visited[nx][ny][nd] == false)
					if(nd == d)
						pq.add(new Node(nx, ny, nd, mirror));
					else
						pq.add(new Node(nx, ny, nd, mirror+1));
					
				
			}
		}
	}
}
