import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[] dice = new int[6]; // 0 위, 1, 2 ,3 ,4 상우하좌, 5 아래
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int k = 0; k < K; k++) {
			int d = Integer.parseInt(st.nextToken());
			d--;
			if(x+dx[d] < 0 || y+dy[d] < 0 || x+dx[d] >= N || y+dy[d] >= M)
				continue;
			
			x += dx[d];
			y += dy[d];
			
			int floor;
			switch (d) {
			case 0: // east
				floor = dice[2];
				dice[2] = dice[0];
				dice[0] = dice[4];
				dice[4] = dice[5];
				if(map[x][y] == 0) {
					map[x][y] = floor;
					dice[5] = floor;
				} else {
					dice[5] = map[x][y];
					map[x][y] = 0;
				}
				break;
			case 1: // west
				floor = dice[4];
				dice[4] = dice[0];
				dice[0] = dice[2];
				dice[2] = dice[5];
				if(map[x][y] == 0) {
					map[x][y] = floor;
					dice[5] = floor;
				} else {
					dice[5] = map[x][y];
					map[x][y] = 0;
				}
				break;
			case 2: // north
				floor = dice[1];
				dice[1] = dice[0];
				dice[0] = dice[3];
				dice[3] = dice[5];
				if(map[x][y] == 0) {
					map[x][y] = floor;
					dice[5] = floor;
				} else {
					dice[5] = map[x][y];
					map[x][y] = 0;
				}
				break;
			case 3: // south
				floor = dice[3];
				dice[3] = dice[0];
				dice[0] = dice[1];
				dice[1] = dice[5];
				if(map[x][y] == 0) {
					map[x][y] = floor;
					dice[5] = floor;
				} else {
					dice[5] = map[x][y];
					map[x][y] = 0;
				}
			}
			sb.append(dice[0])
				.append("\n");
		}
		System.out.println(sb);
	}
}

