import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] maze = new char[N][];
		
		for(int n = 0; n < N; n++) {
			String str = br.readLine();
			maze[n] = str.toCharArray();
		}
		
		Queue<Vertex> q = new LinkedList<Vertex>();
		Vertex init = new Vertex(0, 0, 1);
		q.add(init);
		
		while(!q.isEmpty()) {
			Vertex curV = q.poll();
			
			if(curV.x == N-1 && curV.y == M-1) {
				System.out.println(curV.len);
				break;
			}
			for(int d = 0; d < 4; d++) {
				int nextX = curV.x + dx[d];
				int nextY = curV.y + dy[d];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M 
						&& maze[nextX][nextY] == '1') {
					q.add(new Vertex(nextX, nextY, curV.len +1));
					maze[nextX][nextY] = '2';
				}
				
			}
		}
		
		
	}
	static class Vertex{
		int x; 
		int y; 
		int len;
		public Vertex(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}
	}
}
