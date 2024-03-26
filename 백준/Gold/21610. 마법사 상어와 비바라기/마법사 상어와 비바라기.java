import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	
	static int[][] map;
	
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	static ArrayList<Point> lib;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	map = new int[n][n];
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < n; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	lib = new ArrayList<>();
    	lib.add(new Point(n-1, 0));
    	lib.add(new Point(n-2, 0));
    	lib.add(new Point(n-1, 1));
    	lib.add(new Point(n-2, 1));
    	
    	for(int year = 0; year < m; year++) {
    		st = new StringTokenizer(br.readLine());
    		int d = Integer.parseInt(st.nextToken()) - 1;
    		int p = Integer.parseInt(st.nextToken());
    		
    		
    		
    		// move lib
    		for(Point l : lib) {
    			l.x += dx[d] * p + n * 100;
    			l.y += dy[d] * p + n * 100;
    			
    			l.x = l.x %n;
    			l.y = l.y %n;
//    			if(l.x < 0)
//    				l.x += n;
//    			if(l.x >= n)
//    				l.x %= n;
//    			if(l.y < 0)
//    				l.y += n;
//    			if(l.y >= n)
//    				l.y %= n;
    		}
    		
    		boolean[][] visited = new boolean[n][n];
    		
    		// growth phase 1
    		for(Point l : lib) {
//    			System.out.println(l.x + " " + l.y);
    			map[l.x][l.y]++;
    		}
    		print();
    		// growth phase 2
    		for(Point l : lib) {
    			int x = l.x;
    			int y = l.y;
    			
    			int cnt = 0;
    			for(int direction = 1; direction < 8; direction=direction+2) {
    				int nx = x + dx[direction];
    				int ny = y + dy[direction];
    				
    				if(nx < 0 || nx >= n || ny < 0 || ny >= n)
    					continue;
    				
    				if(map[nx][ny] > 0)
    					cnt++;
    			}
    			
    			visited[x][y] = true;
    			map[x][y] += cnt;
    		}
    		print();
    		// new lib
//    		ArrayList<Point> newlib = new ArrayList<>();
    		lib = new ArrayList<>();
    		for(int i = 0; i < n; i++) {
    			for(int j = 0; j < n; j++) {
    				if(visited[i][j])
    					continue;
    				if(map[i][j] >= 2) {
    					map[i][j] -= 2;
    					lib.add(new Point(i, j));
    				}
    			}
    		}
    	}
    	
    	int sum = 0;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			sum += map[i][j];
//    			System.out.print(map[i][j] + " ");
    		}
//    		System.out.println();
    	}
    	
    	System.out.println(sum);
    	
    }
    
    public static void print() {
//    	for(int i = 0; i < n; i++) {
//    		for(int j = 0; j < n; j++) {
//    			System.out.print(map[i][j] + " ");
//    		}
//    		System.out.println();
//    	}
//    	System.out.println();
    }
    static class Point{
    	int x;
    	int y; 
    	Point(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    }
}