import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[][] synergy;
	static int N;
	static int minTaste;
	static int[] com;
	static int[] comTable;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			synergy = new int[N+1][N+1];
			minTaste = Integer.MAX_VALUE;
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			com = new int[N/2];
			com[0] = 1;
			comTable = new int[N+1];
			comTable[1] = 1;
			combination(1, 2);
			
			
			
			sb.append("#")
			.append(t)
			.append(" ")
			.append(minTaste)
			.append("\n");
		}
		
		System.out.println(sb);
	}

	static void combination(int curLen, int start) {
		if(curLen == N/2) {
			calculation();
			return;
		}
		
		for(int i = start; i <= N; i++) {
			com[curLen] = i;
			comTable[i] = 1;
			combination(curLen+1, i+1);
			comTable[i] = 0;
		}
	}
	
	static void calculation() {
		// com에 있는 재료에 대해 계산
		int taste1 = 0;
		for(int i = 0; i < N/2; i++) {
			for(int j = i+1; j < N/2; j++) {
				taste1 += synergy[com[i]][com[j]];
				taste1 += synergy[com[j]][com[i]];
			}
		}
		// 없는 재료에 대해 계산
		int com2[] = new int[N/2];
		int index = 0;
//		System.out.println(Arrays.toString(comTable));
		for(int i = 1; i <= N; i++) {
			if(comTable[i] == 0) {
				com2[index++] = i;
			}
		}
//		System.out.println("com2 " + Arrays.toString(com2));
		for(int i = 0; i < N/2; i++) {
			for(int j = i+1; j < N/2; j++) {
				taste1 -= synergy[com2[i]][com2[j]];
				taste1 -= synergy[com2[j]][com2[i]];
			}
		}
//		System.out.println("teste " +taste1);
		minTaste = Math.min(minTaste, Math.abs(taste1));
	}
}
