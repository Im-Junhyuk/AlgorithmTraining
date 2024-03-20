import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main{
	
	static int N;
	static int K;
	
	static int[][] board;
	static Piece[] pieces;
	static ArrayDeque<Piece>[][] boardDeques;
	
	static int result;
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Piece{
		int id;
		int x;
		int y;
		int d;
		
		Piece(int id, int x, int y, int d){
			this.id = id;
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// init start
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		pieces = new Piece[K];
		boardDeques = new ArrayDeque[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				boardDeques[i][j] = new ArrayDeque<>();
			}
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			
			switch (d) {
				case 1:
					d = 2;
					break;
				case 2:
					d = 1;
					break;
			}
			
			pieces[i] = new Piece(i, x, y, d);
			boardDeques[x][y].add(pieces[i]);
		}
		
		// init end
		
		// start game
		
		result = -1;
		play();

		
		System.out.println(result);
	}
	
	static void play() {
		int turn = 1;
		while(turn <= 1000) {
//			System.out.println("t " + turn);
			for(int i = 0; i < K; i++) {
//				System.out.println(" i " + i);
				Piece p = pieces[i];
				
				// check bottom
				Piece bottom = boardDeques[p.x][p.y].peekFirst();
				if(p.id != bottom.id)
					continue;
				
				int nx = p.x + dx[p.d];
				int ny = p.y + dy[p.d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 2) {
					p.d = (p.d+2)%4;
					nx += 2 * dx[p.d];
					ny += 2 * dy[p.d];
					
				}
//				System.out.println("  " + nx + " " + ny);
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 2)
					continue;
				else if(board[nx][ny] == 1)
					moveRed(i, nx, ny);
				else if(board[nx][ny] == 0)
					moveWhite(i, nx, ny);
				
				if(boardDeques[nx][ny].size() >= 4) {
					result = turn;
					return;
				}
			}
			
			turn++;
		}
	}
	
	static void moveRed(int idx, int x, int y) {
		ArrayDeque<Piece> from = boardDeques[pieces[idx].x][pieces[idx].y];
		ArrayDeque<Piece> to = boardDeques[x][y];
		
		while(!from.isEmpty()) {
			Piece p = from.pollLast();
			p.x = x;
			p.y = y;
			to.add(p);
		}
	}
	
	static void moveWhite(int idx, int x, int y) {
		ArrayDeque<Piece> from = boardDeques[pieces[idx].x][pieces[idx].y];
		ArrayDeque<Piece> to = boardDeques[x][y];
		
		while(!from.isEmpty()) {
			Piece p = from.pollFirst();
			p.x = x;
			p.y = y;
			to.add(p);
		}
	}
}
