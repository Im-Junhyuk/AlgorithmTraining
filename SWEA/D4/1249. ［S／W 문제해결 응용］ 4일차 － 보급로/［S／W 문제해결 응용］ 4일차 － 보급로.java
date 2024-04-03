import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			
			int map[][] = new int[N][N];
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			boolean[][] visited = new boolean[N][N];
			PriorityQueue<Node> pq = new PriorityQueue<>(
					(n1, n2) ->
					n1.dist - n2.dist);
			pq.add(new Node(0, 0, 0));
			int result = 0;
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				int x = cur.x;
				int y = cur.y;
				int dist = cur.dist;
				
				if(x == N-1 && y == N-1) {
					result = dist;
					break;
				}
				
				if(visited[x][y])
					continue;
				visited[x][y] = true;
				
				for(int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(nx <0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
						continue;
					
					pq.add(new Node(nx, ny, dist+map[x][y]));
				}
			}
			
			sb.append("#")
				.append(tc)
				.append(" ")
				.append(result)
				.append("\n");
			
		}
		
		System.out.print(sb);
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
}
