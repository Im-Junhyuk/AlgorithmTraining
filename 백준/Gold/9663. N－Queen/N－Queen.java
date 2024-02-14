import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	static int[] nqArr;
	static int count = 0;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nqArr = new int[N];
		nq(0);
		System.out.println(count);
	}
	
	static void nq(int n) {
		if(n == N) {
			count++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isGood(n, i)) {
				nqArr[n] = i;
				nq(n+1);
			}
		
		}
	}
	
	static boolean isGood(int row, int col) {
		for(int i = 0; i < row; i++) {
			if(nqArr[i] == col || (row - i) == Math.abs(col - nqArr[i]))
				return false;
		}
		return true;
	}
}
