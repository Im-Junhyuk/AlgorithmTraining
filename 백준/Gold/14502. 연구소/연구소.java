import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	
	static ArrayList<Point> emptyRoom;
	static ArrayList<Point> virus;
	static ArrayList<int[]> comList = new ArrayList<>();
	
	static int[] temp = new int[3];
	
	static boolean[][] visited;
	static int safeArea = Integer.MIN_VALUE;
	static int curSafeArea;
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		emptyRoom = new ArrayList<>();
		virus = new ArrayList<>();
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m] == 0)
					emptyRoom.add(new Point(n, m));
				else if(map[n][m] == 2)
					virus.add(new Point(n, m));
			}
		}
		
		combination(0, 0);
		
		for(int[] com : comList) {
//			System.out.println(Arrays.toString(com));
			
			// make empty space to wall
			for(int i : com) {
				Point p = emptyRoom.get(i);
				map[p.x][p.y] = 1;
			}
			// dfs with virus counting visited
			visited = new boolean[N][M];
			curSafeArea = emptyRoom.size()-3;
			for(Point v : virus) {
				dfs(v.x, v.y);
			}
			safeArea = curSafeArea;
			
			// wall to space
			for(int i : com) {
				Point p = emptyRoom.get(i);
				map[p.x][p.y] = 0;
			}
		}
		
		System.out.println(safeArea);
	}
	
	static void combination(int start, int len) {
		if(len == 3) {
			comList.add(Arrays.copyOf(temp, temp.length));
			return;
		}
		
		for(int i = start; i < emptyRoom.size(); i++) {
			temp[len] = i;
			combination(i+1, len+1);
		}
	}
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static void dfs(int x, int y) {
		if(curSafeArea <= safeArea)
			return;
		
		visited[x][y] = true;
		if(map[x][y] == 0)
			curSafeArea--;
		
		for(int d = 0; d < 4; d++) {
			int newX = x + dx[d];
			int newY = y + dy[d];
			
			if(newX >= 0 && newY >= 0 && newX < N && newY < M 
					&& map[newX][newY] == 0
					&& visited[newX][newY] == false)
				dfs(newX, newY);
		}
	}
}
