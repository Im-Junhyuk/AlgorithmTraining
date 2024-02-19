import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] sushi = new int[N];
		for(int n = 0; n < N; n++) {
			sushi[n] = Integer.parseInt(br.readLine());
		}
		
		int[] dishes = new int[d+1];
		int count = 1;
		dishes[c]++;
		
		for(int i = 0; i < k; i++) {
			if(dishes[sushi[i]] == 0)
				count++;
			dishes[sushi[i]]++;
		}
		
		int maxCount = count;
		for(int i = 1; i < N; i++) {
			
			dishes[sushi[i-1]]--;
			if(dishes[sushi[i-1]] == 0)
				count--;
			
			if(dishes[sushi[(k+i-1)%N]] == 0)
				count++;
			dishes[sushi[(k+i-1)%N]]++;
			
			maxCount = Math.max(maxCount, count);
		}
		System.out.println(maxCount);
		
	}
}