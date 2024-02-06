import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int M;
	static int[] snack;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			sb.append("#")
			.append(tc)
			.append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++)
				snack[n] = Integer.parseInt(st.nextToken());
			
			sb.append(combination())
			.append("\n");
		}
		System.out.println(sb);
	}
	
	static int combination() {
		int maxWeight = -1;
		int curWeight = 0;
		
		for(int i = 0; i < N; i++) {
			curWeight = snack[i];
			for(int j = i + 1;j < N; j++) {
				curWeight += snack[j];
				if(curWeight <= M && curWeight > maxWeight)
					maxWeight = curWeight;
				curWeight -= snack[j];
			}
		}
		return maxWeight;
		
	}

}
