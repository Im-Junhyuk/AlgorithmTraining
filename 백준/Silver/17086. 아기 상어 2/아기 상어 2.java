import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = { 1, 0, -1, 1, -1, 1, 0, -1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int water[][] = new int[N][M];
		Queue<Shark> q = new LinkedList<>();
		
		int safeDist = 0;
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int k = Integer.parseInt(st.nextToken());
				if (k == 1) {
					water[i][j] = 1;
					q.add(new Shark(i, j));
				}
			}
		}
		
		//bfs
		Shark curShark;
		int nextX;
		int nextY;
		
		while(!q.isEmpty()) {
			curShark = q.poll();
//			if(water[curShark.x][curShark.y] != 0)
//				continue;
			
			for(int i = 0; i < 8; i++) {
				nextX = curShark.x + dx[i];
				nextY = curShark.y + dy[i];
				
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && water[nextX][nextY] == 0) {
					water[nextX][nextY] = water[curShark.x][curShark.y] +1 ; 
					safeDist = Math.max(water[nextX][nextY], safeDist);
					q.add(new Shark(nextX, nextY));
				}
			}
			
		}
		
		// print stored dist -1
		System.out.println(safeDist - 1);
		
	}
}

class Shark{
	int x;
	int y;
	
	public Shark(int x, int y) {
		this.x = x;
		this.y = y;
	}
}