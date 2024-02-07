import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] paper = new int[100][100];
		
		int paperNum = Integer.parseInt(br.readLine());
		
		for(int p = 0; p < paperNum; p++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = x; i < x + 10; i++) {
				for(int j = y; j < y + 10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		int black = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(paper[i][j] == 1)
					black++;
			}
		}
		
		System.out.println(black);
	}

}
