import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean complete = false;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new int[9][9];
		for(int i = 0; i < 9; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bt(0, 0);
		
//		print();
	}
	
	static void bt(int x, int y) {
		if(x == 8 && y == 9) {
			print();
			complete = true;
			return;
		}
		
		if(y == 9) {
			x++;
			y = 0;
		}
		
		if(map[x][y] != 0)
			bt(x, y+1);
		
		if(map[x][y] == 0)
			for(int i = 1; i <= 9; i++) {
				if(complete == false) {
					if(validCheck(x, y, i)) {
						map[x][y] = i;
						bt(x, y+1);
						map[x][y] = 0;
					}
				}
			}
	}
	
	static boolean validCheck(int x, int y, int value) {
		
		Set<Integer> set = new HashSet<>();
		
		for(int row = 0; row < 9; row++) {
			set.add(map[row][y]);
		}
		
		if(set.contains(value))
			return false;
		
		set = new HashSet<>();
		for(int col = 0; col < 9; col++) {
			set.add(map[x][col]);
		}
		
		if(set.contains(value))
			return false;
		
		x = x - x%3;
		y = y - y%3;
		
		set = new HashSet<>();
		
		for(int r = x; r < x+3; r++) {
			for(int c = y; c < y+3; c++) {
				set.add(map[r][c]);
			}
		}
		if(set.contains(value))
			return false;
		
		return true;
	}
	
	static void print() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}