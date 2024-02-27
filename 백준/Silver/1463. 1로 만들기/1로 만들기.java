import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] result = new int[N+1];
	
		for(int i = 2; i <= N; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			if(i % 3 == 0)
				temp.add(result[i/3] + 1);
			if(i % 2 == 0)
				temp.add(result[i/2] + 1);
			temp.add(result[i - 1] + 1);
			
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < temp.size(); j++) {
				min = Math.min(min, temp.get(j));
			}
			result[i] = min;
		} 
		
		System.out.println(result[N]);
	}

}
