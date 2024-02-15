import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	static boolean[] visited;
	static int curDist;
	static int minDist;
	static int consumerCnt;
	static int N;
	
	static int[] companyToConsumer;
	static int[] consumerToHome;
	static int[][] consumerToConsumer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int[] company = new int[2];
			int[] home = new int[2];
			
			int[][] consumer = new int[N][2];
			
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			for(int n = 0; n < N; n++) {
				consumer[n][0] = Integer.parseInt(st.nextToken());
				consumer[n][1] = Integer.parseInt(st.nextToken());
			}
			
			companyToConsumer = new int[N];
			consumerToHome = new int[N];
			
			for(int n = 0; n < N; n++) {
				companyToConsumer[n] = Math.abs(company[0] - consumer[n][0]) 
						+ Math.abs(company[1] - consumer[n][1]);
				consumerToHome[n] = Math.abs(home[0] - consumer[n][0]) 
						+ Math.abs(home[1] - consumer[n][1]);
//				System.out.println(consumerToHome[n]);
			}
			
			consumerToConsumer = new int[N][N];
			for(int n1 = 0; n1 < N; n1++) {
				for(int n2 = 0; n2 < n1; n2++) {
					int dist = Math.abs(consumer[n1][0] - consumer[n2][0])
							+ Math.abs(consumer[n1][1] - consumer[n2][1]);
					consumerToConsumer[n1][n2] = dist;
					consumerToConsumer[n2][n1] = dist;
				}
			}

			minDist = Integer.MAX_VALUE;
			for(int n = 0; n < N; n++) {
				curDist = companyToConsumer[n];
				visited = new boolean[N];
				consumerCnt = 1;
				visited[n] = true;
				
				bt(n);

			}
			
			sb.append("#")
				.append(t)
				.append(" ")
				.append(minDist)
				.append("\n");
			
		}
		System.out.println(sb);
	}	
	static void bt(int start) {
		if(consumerCnt == N) {
			curDist += consumerToHome[start];
			minDist = Math.min(minDist, curDist);
			curDist -= consumerToHome[start];
			return;
		}
		
		for(int n = 0; n < N; n++) {
			if(visited[n] == false) {
				visited[n] = true;
				curDist += consumerToConsumer[start][n];
				consumerCnt++;
				
				bt(n);
				
				visited[n] = false;
				curDist -= consumerToConsumer[start][n];
				consumerCnt--;
			}
		}
	}
}
