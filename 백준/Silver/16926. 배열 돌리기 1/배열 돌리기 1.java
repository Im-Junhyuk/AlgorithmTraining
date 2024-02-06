import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int M;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N][M];
		
		for(int i = 0;i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int r = 0; r < R; r++) {
			array = R(array);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(array[i][j])
				.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int[][] R(int[][] origin) {
		int[][] temp = new int[N][M];
		
		int x = 0; 
		int y = 0;
		int d = 0;
		int count = 0;
		while(count++ < N*M) {
//			System.out.println(count);
			
			if(x+dx[d] <0 || x+dx[d] >= N || y+dy[d] < 0 || y+dy[d] >= M || temp[x+dx[d]][y+dy[d]] != 0)
				d = (d+1)%4;
			temp[x+dx[d]][y+dy[d]] = origin[x][y];
			origin[x][y] = 0;
			if(origin[x+dx[d]][y+dy[d]] == 0)
				d = (d+1)%4;
			
			x += dx[d];
			y += dy[d];
		}
		return temp;
		
	}
}