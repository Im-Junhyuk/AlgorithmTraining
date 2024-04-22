import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
	
	static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
	static int[] dy = {1, -1, -1, 0, 1, -1, 0, 1};
	
	static int[] mdx = {0, 0, 1, -1};
	static int[] mdy = {1, -1, 0, 0};
	
	static Queue<State> q;
	static int N;
	static char[][] map;
	static Set<Integer> visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		int[][] train = new int[3][2];
		int cnt = 0;
		visited = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'B') {
					train[cnt][0] = i;
					train[cnt][1] = j;
					cnt++;
					map[i][j] = 0;
				}
			}
		}
		q = new LinkedList<>();
		q.add(new State(train, -1));
		
		while(!q.isEmpty()) {
			State cur = q.poll();
			train = cur.train;
			cnt = cur.cnt;
//			System.out.println(cnt);
			if(map[train[0][0]][train[0][1]] == 'E'
					&& map[train[1][0]][train[1][1]] == 'E'
					&& map[train[2][0]][train[2][1]] == 'E') {
				System.out.println(cnt);
				return;
			}
			
			int hash = hash(train);
			if(visited.contains(hash)) {
				continue;
			}
			
			visited.add(hash);
			
			for(int d = 0; d < 4; d++) {
				int[][] newTrain = new int[3][2];
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 2; j++) {
						newTrain[i][j] = train[i][j];
					}
				}
				
				for(int i = 0; i < 3; i++) {
					newTrain[i][0] += mdx[d];
					newTrain[i][1] += mdy[d];
				}
				
				if(validCheck(newTrain)) {
					q.add(new State(newTrain, cnt));
				}
			}
			
			if(rotationCheck(train)) {
//				int[][] newTrain = new int[3][2];
				if(train[0][0] == train[1][0]) {
					train[0][0] = train[1][0] -1;
					train[0][1] = train[1][1];
					
					train[2][0] = train[1][0] + 1;
					train[2][1] = train[1][1];
					
				} else {
					train[0][0] = train[1][0];
					train[0][1] = train[1][1] -1;
					
					train[2][0] = train[1][0];
					train[2][1] = train[1][1]+1;
				}
				
				if(validCheck(train)) {
					q.add(new State(train, cnt));
				}
			}
		}
		
		System.out.println(0);
	}
	
	static boolean rotationCheck(int[][] train) {
		int x = train[1][0];
		int y = train[1][1];
		
		for(int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == '1')
				return false;
		}
		
		return true;
	}
	
	static boolean validCheck(int[][] newTrain) {
		for(int i = 0; i < 3; i++) {
			if(newTrain[i][0] < 0 || newTrain[i][0] >= N
					|| newTrain[i][1] <0 || newTrain[i][1] >= N
					|| map[newTrain[i][0]][newTrain[i][1]] == '1')
				return false;
		}
		
		int hash = hash(newTrain);
		if(visited.contains(hash))
			return false;
		
		return true;
		
	}
	static void left(int[][] train, int cnt) {
		int[][] newT = new int[3][2];
		
	}
	static class State{
		int[][] train;
		int cnt;
		
		State(int[][] train, int cnt){
			this.train = new int[3][2];
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 2; j++) {
					this.train[i][j] = train[i][j];
				}
			}
			this.cnt = cnt+1;
		}
	}
	
	static int hash(int[][] train) {
		int hash = 0;
		hash += train[1][0] * 100;
		hash += train[1][1];
		
		if(train[0][0] == train[1][0]) {
			hash += 10000;
		}
		
		return hash;
	}
}
