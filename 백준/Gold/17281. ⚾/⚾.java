import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N; 
	static int[][] hittingResult;
	
	static int[] roster;
	static int[] temp;
	static boolean[] visited;
	static int maxScore = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		hittingResult = new int[N][9];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				hittingResult[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		temp = new int[8];
		visited = new boolean[9];
		
		combination(0);
		
		System.out.println(maxScore);
	}
	static void combination(int len) {
		if(len == temp.length) {
			completeRoster();
			play();
//			System.out.println(Arrays.toString(roster));
			return;
		}
		
		for(int i = 1; i < temp.length+1; i++) {
			if(visited[i] == false) {
				temp[len] = i;
				visited[i] = true;
				combination(len+1);
				visited[i] = false;
			}
		}
	}
	static void completeRoster() {
		roster = new int[9];
		int left = 0;
		for(int i = 0; i < 9; i++) {
			if(i == 3) {
				roster[i] = 0;
				continue;
			}
			roster[i] = temp[left];
			left++;
		}
	}
	
	static void play() {
		
		int score = 0;
		int hitter = -1;
		for(int i = 0; i < N; i++) {
			
			int outCount = 0;
			int base1 = 0;
			int base2 = 0;
			int base3 = 0;
			while(outCount < 3) {
				hitter = (hitter+1)%9;
				
				switch (hittingResult[i][roster[hitter]]) {
				case 0:
					outCount++;
					break;
				case 1:
					score += base3;
					base3 = base2;
					base2 = base1;
					base1 = 1;
					break;
				case 2:
					score += base3 + base2;
					base3 = base1;
					base2 = 1;
					base1 = 0;
					break;
				case 3:
					score += base3 + base2 + base1;
					base3 = 1;
					base2 = 0;
					base1 = 0;
					break;
				case 4:
					score += base3 + base2 + base1 + 1;
					base3 = 0;
					base2 = 0;
					base1 = 0;
				}
			}
		}
		maxScore = Math.max(maxScore, score);
	}
}
