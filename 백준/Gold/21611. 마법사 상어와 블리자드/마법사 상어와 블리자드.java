import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int player = n / 2;
		
		int[][] map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int score = 0;
		for(int turn = 1; turn <= m; turn++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int attackRange = Integer.parseInt(st.nextToken());
			
			switch (d) {
			case 1:
				d = 3;
				break;
			case 2:
				d = 1;
				break;
			case 3:
				d = 2;
				break;
			case 4:
				d = 0;
			}
			
			int x = player;
			int y = player;
			for(int dist = 1; dist <= attackRange; dist++) {
				x += dx[d];
				y += dy[d];
//				score += map[x][y];
				map[x][y] = -1;
			}
			
			// delete space
			d = 2; // d = (d+3)%4
			x = player;
			y = player;
			ArrayDeque<Record> dq = new ArrayDeque<>();
			while(true) {
				
				x += dx[d];
				y += dy[d];
				
				if(x < 0 || x >= n || y < 0 || y >= n)
					break;
				
				if(map[x][y] == 0) { 
					break;
				} else if(map[x][y] != -1) {
//					System.out.print(map[x][y] + " ");
					if(dq.isEmpty())
						dq.addLast(new Record(map[x][y], 1));
					else {
						Record top = dq.peekLast();
						if(top.value == map[x][y]) {
							top.cnt++;
						} else {
							dq.addLast(new Record(map[x][y], 1));
						}
					}
				}
				
				map[x][y] = 0;
				int left = (d+3)%4;
				
				if(map[x+dx[left]][y+dy[left]] != 0)
					d = left;
			}
			// dq clear to end
			int explode = 0;
			while (true) {
				explode = 0;
				int len = dq.size();
				for(int l = 0; l < len; l++) {
					Record r = dq.pollFirst();
					if(r.cnt >= 4) {
						explode++;
						score += r.cnt * r.value;
					} else {
						dq.addLast(r);
					}
				}
				if(explode == 0)
					break;
				
				len = dq.size();
				for(int l = 0; l < len; l++) {
					Record r = dq.pollFirst();
					if(l == 0) {
						dq.addLast(r);
						continue;
					}
					
					Record last = dq.peekLast();
					if(r.value == last.value)
						last.cnt += r.cnt;
					else
						dq.addLast(r);
				}
			}
			
			// set map again
			d = 2;
			x = player;
			y = player;
			map = new int[n][n];
			map[x][y] = 1;
			while(!dq.isEmpty()) {
				
				x += dx[d];
				y += dy[d];
				
				if(x < 0 || x >= n || y < 0 || y >= n)
					break;
				
				Record cur = dq.pollFirst();
				int value = cur.value;
				int cnt = cur.cnt;
//				System.out.print(cnt + " " + value + " ");
				map[x][y] = cnt;
				int left = (d+3)%4;
				
				if( map[x+dx[left]][y+dy[left]] == 0)
					d = left;
				
				x += dx[d];
				y += dy[d];
				
				if(x < 0 || x >= n || y < 0 || y >= n)
					break;
				
				map[x][y] = value;
				left = (d+3)%4;
				
				if(map[x+dx[left]][y+dy[left]] == 0)
					d = left;
			}
//			System.out.println();
			map[player][player] = 0;
		}

		
		System.out.println(score);
	}
	static class Record{
		int value;
		int cnt;
		Record(int value, int cnt){
			this.value = value;
			this.cnt = cnt;
		}
	}
}
