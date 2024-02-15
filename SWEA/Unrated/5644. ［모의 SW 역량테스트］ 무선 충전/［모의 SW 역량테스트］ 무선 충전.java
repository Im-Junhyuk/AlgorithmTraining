import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = {0, 0, 1, 0, -1};
	static int[] dy = {0, -1, 0, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			int[] aMove = new int[M+1];
			int[] bMove = new int[M+1];
			
			st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				aMove[m] = Integer.parseInt(st.nextToken());
				bMove[m] = Integer.parseInt(st2.nextToken());
			}
			
			int[][] bc = new int[A+1][4];
			bc[0][2] = 20;
			bc[0][3] = 0;
			// a = 0 for nothing.
			for(int a = 1; a < A+1; a++) { // 0 is row, 1 is col, 2 : dist, 3 : perf
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < 4; i++) {
					bc[a][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			int aX = 1;
			int aY = 1;
			
			int bX = 10;
			int bY = 10;
			
			int totalChargeAmount = 0;
			
			for(int m = 0; m <= M; m++) {
				
				// add candidates to lists respectively
				ArrayList<Integer> aList = new ArrayList<>();
				ArrayList<Integer> bList = new ArrayList<>();
				for(int a = 0; a < A+1; a++) {
					int aDist = Math.abs(aX - bc[a][0]) + Math.abs(aY - bc[a][1]);
					int bDist = Math.abs(bX - bc[a][0]) + Math.abs(bY - bc[a][1]);
					if(aDist <= bc[a][2])
						aList.add(a);
					if(bDist <= bc[a][2])
						bList.add(a);
				}
				
				// decide what is the best choice
				int maxChargeAmount = Integer.MIN_VALUE;
				int curChargeAmount;
				for(int aBC : aList) {
					for(int bBC : bList) {
						curChargeAmount = 0;
						if(aBC == bBC) {
							curChargeAmount = bc[aBC][3];
						} else {
							curChargeAmount = bc[aBC][3] + bc[bBC][3];
						}
						maxChargeAmount = Math.max(maxChargeAmount, curChargeAmount);
					}
				}
				
				// result update
				totalChargeAmount += maxChargeAmount;
				
				// move
				aX += dx[aMove[m]];
				aY += dy[aMove[m]];
				bX += dx[bMove[m]];
				bY += dy[bMove[m]];
			}
			
			sb.append("#")
				.append(t)
				.append(" ")
				.append(totalChargeAmount)
				.append("\n");
			
		}
		
		System.out.println(sb);
	}

}
