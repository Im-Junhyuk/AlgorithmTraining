import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static Comparator<Marble>[] com;
	
	static class State{
		int turn;
		Marble[] marbles;
		State(){
			this.turn = 0;
			marbles = new Marble[2];
		}
		public State(int turn, int rx, int ry, int bx, int by) {
			this.turn = turn;
			this.marbles = new Marble[2];
			marbles[0] = new Marble('R', rx, ry);
			marbles[1] = new Marble('B', bx, by);
		}
	}
	
	static class Marble{
		char color;
		int x;
		int y;
		public Marble(char color, int x, int y) {
			this.color = color;
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		State init = new State();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') {
					init.marbles[0] = new Marble('R', i, j);
					map[i][j] = '.';
				} else if(map[i][j] == 'B') {
					init.marbles[1] = new Marble('B', i, j);
					map[i][j] = '.';
				}
			}
		}
		
		com = new Comparator[4];
		com[0] = new Comparator<Marble>() {
			
			@Override
			public int compare(Marble o1, Marble o2) {
				return o2.y-o1.y;
			}
		};
		com[1] = new Comparator<Marble>() {
			
			@Override
			public int compare(Marble o1, Marble o2) {
				return o2.x-o1.x;
			}
		};
		com[2] = new Comparator<Marble>() {
			
			@Override
			public int compare(Marble o1, Marble o2) {
				return o1.y-o2.y;
			}
		};
		com[3] = new Comparator<Marble>() {
			
			@Override
			public int compare(Marble o1, Marble o2) {
				return o1.x-o2.x;
			}
		};

		
		System.out.println(play(init));
		
	}
	public static int play(State init) {
		
		Set<Integer> visited = new HashSet<>();
		Queue<State> q = new LinkedList<>();
		q.add(init);
		visited.add(visit(init));
		
		while(!q.isEmpty()) {
			State cur = q.poll();
			
			if(cur.turn >= 10)
				return 0;
			
			Marble[] marbles = cur.marbles;
			for(int d = 0; d < 4; d++) {
				
				int rx = 0;
				int ry = 0;
				int bx = 0; 
				int by = 0;
				boolean fail = false;
				boolean success = false;
				Arrays.sort(marbles, com[d]);
				
				for(int m = 0; m < 2; m++) {
					// rolling
					Marble marble = cur.marbles[m];
					int x = marble.x;
					int y = marble.y;
					
					while(true) {
						char next = map[x+dx[d]][y+dy[d]];
						
						if(next == 'O') {
							if(marble.color == 'R')
								success = true;
							else
								fail = true;
							break;
						}
						
						if(next != '.') {
							if(marble.color == 'R') {
								rx = x;
								ry = y;
							} else {
								bx = x;
								by = y;
							}
							map[x][y] = 'M';
									
							break;
						}
						
						x += dx[d];
						y += dy[d];
					}
					

				}
				map[rx][ry] = '.';
				map[bx][by] = '.';
//				if(success)
//					System.out.println(fail);
				if(fail)
					continue;
				if(success)
					return 1;
				
				// visited check, q add
				State add = new State(cur.turn+1, rx, ry, bx, by);
				int hash = visit(add);
				if(!visited.contains(hash)) {
					visited.add(hash);
					q.add(add);
				}
			}
		}
		return 0;
	}
	
	public static int visit(State state) {
		int result = 1000*state.marbles[0].x + 100*state.marbles[0].y 
				+ 10*state.marbles[1].x + state.marbles[1].y;
		return result;
	}
}
