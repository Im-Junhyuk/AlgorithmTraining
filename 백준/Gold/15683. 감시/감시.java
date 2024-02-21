import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] room;
	static int space;
	static int minSpace = Integer.MAX_VALUE;
	static int N;
	static int M;
	
	static ArrayList<CCTV> cctv;
//	static ArrayList<CCTV> cctv2;
//	static ArrayList<CCTV> cctv3;
//	static ArrayList<CCTV> cctv4;
	static ArrayList<CCTV> cctv5;
	
	static int[][] dx = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		room = new int[N][M];
		space = 0;
		
		cctv = new ArrayList<>();
//		cctv2 = new ArrayList<>();
//		cctv3 = new ArrayList<>();
//		cctv4 = new ArrayList<>();
		cctv5 = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				switch (room[i][j]) {
				case 0:
					space++;
					break;
				case 5:
					cctv5.add(new CCTV(i, j, 5));
					break;
				case 1: 
				case 2:
				case 3:
				case 4:
					cctv.add(new CCTV(i, j, room[i][j]));
				}
			}
		}
		
		for(CCTV cctv : cctv5) {
			useCCTV5(cctv);
		}
		
		turnOn(0);
//		System.out.println(cctv.size());
		System.out.println(minSpace);
	}
	static class CCTV{
		int x; 
		int y;
		int num;
		CCTV(int x, int y, int num){
			this.x = x; 
			this.y = y;
			this.num = num;
		}
	}
	
	static void turnOn(int cctvNum) {
		if(cctvNum == cctv.size()) {
			minSpace = Math.min(space, minSpace);
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < M; j++) {
//					System.out.print(room[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			return;
		}
		int x = cctv.get(cctvNum).x;
		int y = cctv.get(cctvNum).y;
			switch (cctv.get(cctvNum).num){
			case 1:
				for(int d = 0; d < 4; d++) {
					useCCTV1(x, y, d);
					turnOn(cctvNum+1);
					restore(x, y, d);
				}
				break;
			case 2:
				for(int d = 0; d < 2; d++) {
					useCCTV1(x, y, d);
					useCCTV1(x, y, d+2);
					turnOn(cctvNum+1);
					restore(x, y, d);
					restore(x, y, d+2);
				}
				break;
			case 3:
				for(int d = 0; d < 4; d++) {
					if(d == 0) {
						useCCTV1(x, y, d);
						useCCTV1(x, y, d+1);
						turnOn(cctvNum+1);
					} else {
						useCCTV1(x, y, d+1);
						restore(x, y, d-1+4);
						turnOn(cctvNum+1);
					}
				}
				restore(x, y, 0);
				restore(x, y, 3);
				break;
			case 4:
				for(int d = 0; d < 4; d++) {
					if(d == 0) {
						useCCTV1(x, y, d-1+4);
						useCCTV1(x, y, d);
						useCCTV1(x, y, d+1);
						turnOn(cctvNum+1);
					} else {
						useCCTV1(x, y, d+1);
						restore(x, y, d-2+4);
						turnOn(cctvNum+1);
						
					}
				}
				restore(x, y, 0);
				restore(x, y, 2);
				restore(x, y, 3);
			}
		
	}
	
	static void sweep(int x, int y, int d) {
		
		d = d % 4;
		while(x +dx[d][0] >= 0 && y + dx[d][1] >= 0
				&& x +dx[d][0] < N && y + dx[d][1] < M) {
			x += dx[d][0];
			y += dx[d][1];
			if(room[x][y] == 6)
				return;
			else if(room[x][y] == 0) {
				room[x][y]--;
				space--;
			} else if(room[x][y] < 0)
				room[x][y]--;
		}
	}

	static void restore(int x, int y, int d) {
		
		d = d % 4;
		while(x +dx[d][0] >= 0 && y + dx[d][1] >= 0
				&& x +dx[d][0] < N && y + dx[d][1] < M) {
			x += dx[d][0];
			y += dx[d][1];
			if(room[x][y] == 6)
				return;
			else if(room[x][y] == -1) {
				room[x][y]++;
				space++;
			} if(room[x][y] < -1)
				room[x][y]++;
		}
	}

	static void useCCTV1(int x, int y, int d) {
		sweep(x, y, d);
	}
	static void useCCTV5(CCTV cctv) {
		int x = cctv.x;
		int y = cctv.y;
		
		for(int d = 0; d < 4; d++) {
			sweep(x, y, d);
		}
	}
}
