import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	
	static int[][] map;
	static int score = 0;
	
	static ArrayList<Bombs> bList;
	static int[][] visited;
	
	static Bombs temp;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		int bombNum = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0)
					bombNum++;
			}
		}
		print();
		
	
		while(bombNum > 0) {
		
			bList = new ArrayList<>();
			search();
//			System.out.println(bombNum);
			// sort
			Collections.sort(bList);
			Bombs biggest = bList.get(0);
			
			if(biggest.totalBombNum == 1)
				break;
			
			// explode
			explode(biggest.r, biggest.c, biggest.id);
			bombNum = bombNum - biggest.totalBombNum + biggest.redNum;
			print();
			
			// score
			score += biggest.totalBombNum * biggest.totalBombNum;
			
			// gravity
			drop();
			print();
			
			// toggle
			toggle();
			print();
			
			// gravity
			drop();
			print();
			
		}
		System.out.println(score);
	}
	
	static void drop() {
		for(int j = 0; j < N; j++) {
			dropCol(j);
		}
	}
	
	static void dropCol(int col) {
		for(int i = N-1; i >= 0; i--) {
			if(map[i][col] == -2)
				dropOne(col, i);
		}
	}
	
	static void dropOne(int col, int row) {
		for(int i = row-1; i >= 0; i--) {
			if(map[i][col] == -1)
				break;
			if(map[i][col] > -1) {
				int temp = map[i][col];
				map[i][col] = -2;
				map[row][col] = temp;
				return;
			}
		}
			
	}
	
	static void toggle() {
		int[][] newMap = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				newMap[i][j] = map[j][N-i-1];
			}
		}
		map = newMap;
	}
	static void search() {
		
		visited = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == 0) {
					if(map[i][j] > 0) {
						temp = new Bombs();
						temp.id = map[i][j];
						temp.r = i;
						temp.c = j;
						searchDfs(i, j);
						bList.add(temp);
					}
				}
			}
		}
	}
	
	static void searchDfs(int r, int c) {
		temp.totalBombNum++;
//		if(map[r][c] == temp.id) {
			
			visited[r][c] = temp.id;
//		}
		
		if(map[r][c] == 0)
			temp.redNum++;
		
		if(map[r][c] != 0 && r < temp.r) {
			temp.r = r;
			temp.c = c;
		}
		
		if(map[r][c] != 0 && r == temp.r)
			temp.c = Math.min(temp.c, c);
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if(map[nr][nc] == temp.id && visited[nr][nc] == 0)
					searchDfs(nr, nc);
				
				if(map[nr][nc] == 0 && visited[nr][nc] != temp.id)
					searchDfs(nr, nc);
				
				
				
			}
		}
	}
	
	static void explode(int r, int c, int id) {
		
		map[r][c] = -2;
		for(int d = 0; d < 4; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];
			
			if(nr >= 0 && nc >= 0 && nr < N && nc < N)
				if(map[nr][nc] == id || map[nr][nc] == 0)
					explode(nr, nc, id);
		}
		
	}
	static void print() {
//		System.out.println("====================");
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
	}
	static class Bombs implements Comparable<Bombs>{
		int id;
		int totalBombNum;
		int redNum;
		int r;
		int c;
		@Override
		public int compareTo(Bombs o) {
			if(this.totalBombNum != o.totalBombNum)
				return o.totalBombNum - this.totalBombNum;
			if(this.redNum != o.redNum)
				return o.redNum - this.redNum;
			
			if(this.r != o.r)
				return o.r - this.r;
			
			return o.c - this.c;
		}
	}
}