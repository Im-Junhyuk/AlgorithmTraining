import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {


	static int[][] rooms;
	static int[][] visited;
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};
	
	static int N;
	
	static int curRoomNum;
	static int roomNum;
	static int startingRoom;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			rooms = new int[N][N];
			

			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			roomNum = 0;
			startingRoom = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visited = new int[N][N];
					curRoomNum = 0;
					dfs(i, j, 0);
					if(curRoomNum > roomNum) {
						roomNum = curRoomNum;
						startingRoom = rooms[i][j];
					} else if(curRoomNum == roomNum)
						startingRoom = Math.min(startingRoom, rooms[i][j]);
				}
			}
			
			sb.append("#")
			.append(t)
			.append(" ")
			.append(startingRoom)
			.append(" ")
			.append(roomNum)
			.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int y, int cur) {
		visited[x][y] = 1;
		cur++;
		for(int d = 0; d < 4; d++) {
			if(x+dx[d] >= 0 && x+dx[d] < N && y+dy[d] >= 0 && y+dy[d] < N &&
					Math.abs(rooms[x][y] - rooms[x+dx[d]][y+dy[d]]) == 1 
					&& visited[x+dx[d]][y+dy[d]] == 0)
				dfs(x+dx[d], y+dy[d], cur);
		}
		if(cur > curRoomNum) {
			curRoomNum = cur;
		}
	}

}
