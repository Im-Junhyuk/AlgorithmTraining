import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] cost = new int[N+1][3];
		st = new StringTokenizer(br.readLine());
		cost[1][0] = Integer.parseInt(st.nextToken());
		cost[1][1] = Integer.parseInt(st.nextToken());
		cost[1][2] = Integer.parseInt(st.nextToken());
		
		for(int i = 2; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) 
					+ Integer.parseInt(st.nextToken());
			cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) 
					+ Integer.parseInt(st.nextToken());
			cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) 
					+ Integer.parseInt(st.nextToken());
		}
		
		int minCost = Integer.MAX_VALUE;
		for(int i = 0; i < cost[0].length; i++) {
			minCost = Math.min(minCost, cost[N][i]);
		}
		System.out.println(minCost);
	}
}
