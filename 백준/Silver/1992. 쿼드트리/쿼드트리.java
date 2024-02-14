import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{

	static char[][] pic;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pic = new char[N][N];
		
		for(int n = 0; n < N; n++) {
			String str = br.readLine();
			for(int i = 0; i < N; i++) {
				pic[n][i] = str.charAt(i);
			}
		}
		
		sb = new StringBuilder();
		dc(0, 0, N);
		System.out.println(sb);
	}
	
	static void dc(int x, int y, int len) {
		if(check(x, y, len)) {
			sb.append(pic[x][y]);
		} else {
			sb.append("(");
			dc(x, y, len/2);
			dc(x, y+len/2, len/2);
			dc(x+len/2, y, len/2);
			dc(x+len/2, y+len/2, len/2);
			sb.append(")");
		}
	}
	
	static boolean check(int x, int y, int len) {
		char num = pic[x][y];
		for(int i = x; i < x+len; i ++) {
			for(int j = y; j < y+len; j++) {
				if(num != pic[i][j])
					return false;
			}
		}
		return true;
	}
}
