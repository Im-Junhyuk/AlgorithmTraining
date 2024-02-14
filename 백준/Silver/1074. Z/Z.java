import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	static int count;
	static int r;
	static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		count = 0;
		
		recurrsion(0, 0, (int) Math.pow(2, N));
	}
	
	static void recurrsion(int x, int y, int len) {
		if(len == 1) {
			
			if(x == r && y == c)
				System.out.println(count);
			count++;
		}
		if(len >= 2) {
			if(x+len/2 > r && y+len/2 > c) {
				recurrsion(x, y, len/2);
			} else {
				count += Math.pow(len/2, 2);
			}
			
			if(x+len/2 > r && y+len/2 <= c) {
				recurrsion(x, y+len/2, len/2);
			} else {
				count += Math.pow(len/2, 2);
			}
			
			if(x+len/2 <= r && y+len/2 > c) {
				recurrsion(x+len/2, y, len/2);
			} else {
				count += Math.pow(len/2, 2);
			}
			
			if(x+len/2 <= r && y+len/2 <= c) {
				recurrsion(x+len/2, y+len/2, len/2);
			} 
		}
	}

}