import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int curLength;
	static int minLength;
	static int curCore;
	static int maxCore;
	
	static ArrayList<Core> cores;
	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st =null;
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cores = new ArrayList<Solution.Core>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						cores.add(new Core(i, j));
					}
				}
			}
			
			curCore = 0;
			minLength = Integer.MAX_VALUE;
			curLength = 0;
			maxCore = Integer.MIN_VALUE;
			
			bt(0);
			
			sb.append("#")
				.append(t)
				.append(" ")
				.append(minLength)
				.append("\n");
			
			
		}
		System.out.println(sb);
	}
	
	static void bt(int cur) {
		if(cur == cores.size()) {
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j<N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			if(curCore > maxCore) {
				maxCore = curCore;
				minLength = curLength;
			} else if(curCore == maxCore)
				minLength = Math.min(minLength, curLength);
			return;
		}
		
		if(cores.size() - cur + curCore< maxCore)
			return;
		
		Core curProcessor = cores.get(cur);
		int x = curProcessor.x;
		int y = curProcessor.y;
		
		if(x == 0 || x == N-1 || y == 0 || y == N-1) {
			curCore++;
			bt(cur+1);
			curCore--;
		} else {
			for(int d = 0; d < 4; d++) {
				boolean link = linkCheck(x, y, d);
				if(link) 
					linkCable(x, y, d);
					bt(cur+1);
				if(link)
					clean(x, y, d);
				
			}
		}
	}
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static boolean linkCheck(int x, int y, int d) {
		int nextX = x + dx[d];
		int nextY = y + dy[d];
		
		while(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
			if(map[nextX][nextY] != 0)
				return false;
			
			nextX += dx[d];
			nextY += dy[d];
			
		}
		
		return true;
	}
	
	static void linkCable(int x, int y, int d) {
		int nextX = x +dx[d];
		int nextY = y + dy[d];
		
		while(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N){
			map[nextX][nextY] = -1;
			nextX += dx[d];
			nextY += dy[d];
			curLength++;
		}
		curCore++;
	}
	
	static void clean(int x, int y, int d) {
		int nextX = x +dx[d];
		int nextY = y + dy[d];
		
		while(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N){
			map[nextX][nextY] = 0;
			nextX += dx[d];
			nextY += dy[d];
			curLength--;
		}
		curCore--;
	}
	static class Core{
		int x;
		int y;
		Core(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
