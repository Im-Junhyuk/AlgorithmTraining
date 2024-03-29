import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Set<Integer>[] like;
	static int[][] map;
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		like = new HashSet[N*N+1];
		
		for(int i = 0; i < N * N; i++) {
			
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			like[id] = new HashSet<>();
			
			for(int j = 0; j < 4; j++) {
				like[id].add(Integer.parseInt(st.nextToken()));
			}
//			System.out.println(id);
			findSeat(id);
		}
		print();
		int score = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int likes = 0;
				int id = map[i][j];
				
				for(int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if(nx >= 0 && ny >= 0 && nx < N && ny < N)
						if(like[id].contains(map[nx][ny]))
							likes++;
				}
				
				switch (likes) {
				case 1:
					score += 1;
					break;
				case 2:
					score += 10;
					break;
				case 3:
					score += 100;
					break;
				case 4:
					score += 1000;
					
				}
			}
		}
		
		System.out.println(score);
	}
	
	static void print() {
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	static void findSeat(int id) {
	
		Seat seat = new Seat();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0)
					continue;
				
				Seat temp = new Seat(i, j);
				// calcul
				for(int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if(map[nx][ny] == 0)
							temp.empty++;
						if(like[id].contains(map[nx][ny]))
							temp.likes++;
					}
				}
				// compare
				if(temp.compareTo(seat) < 0)
					seat = temp;
			}
		}
//		System.out.println("   " + seat.r + " " + seat.c);
		map[seat.r][seat.c] = id; 
	}
	
	static class Seat implements Comparable<Seat>{
		int r;
		int c;
		int likes;
		int empty;
		Seat(){
			likes = 0;
			empty = 0;
			r = Integer.MAX_VALUE;
			c = Integer.MAX_VALUE;
		}
		Seat(int r, int c){
			likes = 0;
			empty = 0;
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Seat o) {
			
			if(this.likes != o.likes)
				return o.likes - this.likes;
			
			if(this.empty != o.empty)
				return o.empty - this.empty;
			
			if(this.r != o.r)
				return this.r - o.r;
			
			return this.c - o.c;
			
		}
	}
}