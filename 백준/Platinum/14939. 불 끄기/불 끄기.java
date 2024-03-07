import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static char[][] light;
	static char[][] temp;
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		light = new char[10][10];
		
		for(int i = 0; i < 10; i++) {
			String str = br.readLine();
			for(int j = 0; j < 10; j++) {
				light[i][j] = str.charAt(j);
			}
		}
		
		int minCnt = Integer.MAX_VALUE;
		for(int r = 0; r < (1<<10); r++) {
			cnt = 0;
			
			temp = new char[10][10];
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					temp[i][j] = light[i][j];
				}
			}
			
			init(r);
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 10; j++) {
					if(temp[i][j] == 'O') {
						cnt++;
						turnOn(i+1, j);
					}
				}
			}
//			System.out.println(cnt + " " + validCheck());
			
			// valid
			if(validCheck())
				minCnt = Math.min(minCnt, cnt);
		}
		
		
		
//			System.out.println();
		if(minCnt == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minCnt);
	}
	
	static void init(int num) {
		for(int i = 0; i < 10; i++) {
			if(((1<<i) & num) != 0) {
				turnOn(0, i);
				cnt++;
			}
		}
	}
	static int dx[] = {0, 1, 0, 0, -1};
	static int dy[] = {0, 0, 1, -1, 0};
	
	static boolean validCheck() {
		
		for(int j = 0; j < 10; j++) {
				if(temp[9][j] == 'O')
					return false;
		}
		
		return true;
	}
	
	static void turnOn(int x, int y) {
		
		for(int d = 0; d < 5; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(nx >= 0 && ny >= 0 && nx < 10 && ny < 10)
				if(temp[nx][ny] == 'O')
					temp[nx][ny] = '#';
				else
					temp[nx][ny] = 'O';
		}
	}
}
