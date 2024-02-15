import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static Game[] gameList;
	static int tableValid;
	static int[][] table;
	static final int gameNum = 15;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = 4;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 0; tc < TC; tc++) {
			table = new int[6][3];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			gameList = new Game[gameNum];
			int index = 0;
			for(int i = 0; i < 6; i++) {
				for(int j = i+1; j < 6; j++) {
					gameList[index++] = new Game(i, j);
				}
			}
			
			
			tableValid = 0;
			bt(0);
			
			sb.append(tableValid)
				.append(" ");
		}
		System.out.println(sb);
	}
	
	static void bt(int depth) {
		if(depth == gameNum) {
			if(vaildCheck())
				tableValid = 1;
			return;
		}
		
		Game thisGame = gameList[depth];
		int team1 = thisGame.team1;
		int team2 = thisGame.team2;
		
		// 1 win
		if(table[team1][0] > 0 && table[team2][2] > 0) {
			table[team1][0]--;
			table[team2][2]--;
			bt(depth+1);
			table[team1][0]++;
			table[team2][2]++;
		}
		
		// draw
		if(table[team1][1] > 0 && table[team2][1] > 0) {
			table[team1][1]--;
			table[team2][1]--;
			bt(depth+1);
			table[team1][1]++;
			table[team2][1]++;
		}
		
		// 1 loss
		if(table[team1][2] > 0 && table[team2][0] > 0) {
			table[team1][2]--;
			table[team2][0]--;
			bt(depth+1);
			table[team1][2]++;
			table[team2][0]++;
		}
		
	}
	
	static boolean vaildCheck() {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				if(table[i][j] != 0)
					return false;
			}
		}
		return true;
	}
	static class Game{
		int team1;
		int team2;
		
		Game(int t1, int t2){
			team1 = t1;
			team2 = t2;
		}
	}
}