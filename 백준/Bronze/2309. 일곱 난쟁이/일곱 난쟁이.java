import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dwarves = new int[9];
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			dwarves[i] = Integer.parseInt(br.readLine());
			sum += dwarves[i];
		}
		Arrays.sort(dwarves);
		
		for(int i = 0; i < 9; i++) {
			int iWeight = dwarves[i];
			for(int j = i+1; j < 9; j++) {
				int jWeight = dwarves[j];
				int result = sum - iWeight - jWeight;
				if(result == 100) {
					for(int k = 0; k < 9; k++) {
						if(k == i || k == j)
							continue;
						System.out.println(dwarves[k]);
					}
					return;
				}
			}
		}
		
	}
}