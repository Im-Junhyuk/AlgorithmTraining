import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {



	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int tankX = 0;
			int tankY = 0;
			
			char[][] map = new char[H][];
			for(int h = 0; h < H; h++) {
				String str = br.readLine();
				map[h] = str.toCharArray();
				for(int w = 0; w < W; w++) {
					if(map[h][w] == '<' || map[h][w] == '>' || 
							map[h][w] == '^' || map[h][w] == 'v') {
						tankX = h;
						tankY = w;
					}
						
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			for(int i = 0; i < N; i++) {
				switch (input.charAt(i)) {
				case ('U'):
					map[tankX][tankY] = '^';
					if(tankX > 0 && map[tankX-1][tankY] == '.') {
						map[tankX-1][tankY] = '^';
						map[tankX][tankY] = '.';
						tankX--;
					}
					break;
				case ('D'):
					map[tankX][tankY] = 'v';
					if(tankX < H-1 && map[tankX+1][tankY] == '.') {
						map[tankX+1][tankY] = 'v';
						map[tankX][tankY] = '.';
						tankX++;
					}
					break;
				case ('L'):
					map[tankX][tankY] = '<';
					if(tankY > 0 && map[tankX][tankY-1] == '.') {
						map[tankX][tankY-1] = '<';
						map[tankX][tankY] = '.';
						tankY--;
					}
					break;
				case ('R'):
					map[tankX][tankY] = '>';
					if(tankY < W-1 && map[tankX][tankY+1] == '.') {
						map[tankX][tankY+1] = '>';
						map[tankX][tankY] = '.';
						tankY++;
					}
					break;
				case ('S'):
					int shellX = tankX;
					int shellY = tankY;
					int dx = 0;
					int dy = 0;
					
					if(map[tankX][tankY] == '<')
						dy = -1;
					else if(map[tankX][tankY] == '>')
						dy = 1;
					else if(map[tankX][tankY] == '^')
						dx = -1;
					else if(map[tankX][tankY] == 'v')
						dx = 1;
					
					while(true) {
						shellX += dx;
						shellY += dy;
						
						if(shellX < 0 || shellY < 0 || shellX >= H || shellY >= W)
							break;
						
						if(map[shellX][shellY] == '*') {
							map[shellX][shellY] = '.';
							break;
						} else if(map[shellX][shellY] == '#')
							break;
					}
				}
			}
			sb.append("#")
				.append(t)
				.append(" ");
			
			for(int h = 0; h < H; h++) {
				for(int w = 0; w < W; w++) {
					sb.append(map[h][w]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
