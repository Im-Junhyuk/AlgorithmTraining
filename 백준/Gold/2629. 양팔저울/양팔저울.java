import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int weight[] = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] weightCanBeMeasured = new boolean[N+1][40001];
		weightCanBeMeasured[0][0] = true;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < weightCanBeMeasured[0].length; j++) {
				if(weightCanBeMeasured[i-1][j] == true) {
					weightCanBeMeasured[i][j] = true;
				
					if(weight[i] + j < 40001)
						weightCanBeMeasured[i][weight[i] + j] = true;
					if(weight[i] - j > 0)
						weightCanBeMeasured[i][weight[i] - j] = true;
					if(j - weight[i] > 0)
						weightCanBeMeasured[i][j - weight[i]] = true;
				}
					
			}
		}
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int m = 0; m < M; m++) {
			int bead = Integer.parseInt(st.nextToken());
			if(weightCanBeMeasured[N][bead])
				sb.append("Y ");
			else
				sb.append("N ");
		}
//		for(int i = 0; i <= N; i++) {
//			for(int j = 0; j < 100; j++) {
//				System.out.print(weightCanBeMeasured[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(sb);
		
	}
}