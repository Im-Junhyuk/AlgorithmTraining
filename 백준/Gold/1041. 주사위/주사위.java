import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		long N = Integer.parseInt(br.readLine());
		
		int[] dice = new int[6];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		long minVertex = Integer.MAX_VALUE;
		long minEdgy = Integer.MAX_VALUE;
		long minFace = Integer.MAX_VALUE;
		
		if(N == 1) {
			int maxIndex = 0;
			int maxValue = 0;
			int sum = 0;
			for(int i = 0; i < 6; i++) {
				sum += dice[i];
				if(maxValue < dice[i]) {
					maxValue = dice[i];
				}
				
			}
			System.out.println(sum-maxValue);
			return;
		}
			
		
		for(int i = 0; i < 6; i++) {
			for(int j = i+1; j < 6; j++) {
				if(i == 0 && j == 5)
					continue;
				if(i == 2 && j == 3)
					continue;
				if(i == 1 && j == 4)
					continue;
				minEdgy = Math.min(minEdgy, dice[i] + dice[j]);
			}
			minFace = Math.min(minFace, dice[i]);
		}
		int[] face1 = new int[]{1, 6};
		int[] face2 = new int[]{2, 5};
		int[] face3 = new int[]{3, 4};
		for(int i : face2) {
			for(int j : face3) {
				for(int k : face1) {
					minVertex = Math.min(minVertex, dice[i-1]+dice[j-1]+dice[k-1]);
				}
			}
		}
//		System.out.println("ver" + minVertex);
//		System.out.println("edge" + minEdgy);
//		System.out.println("face" + minFace);
		long result = 0;
		result += 4 * minVertex;
		result += (8 * N - 12) * minEdgy;
		result += (5 * N * N - 16 * N + 12) *minFace;
		
		System.out.println(result);
	}
}