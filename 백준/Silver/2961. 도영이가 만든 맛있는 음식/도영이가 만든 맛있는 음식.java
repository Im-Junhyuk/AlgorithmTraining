import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int min, s, b, result;
	static int[] sour, bitter;
	static boolean[] isSelected;
	static boolean flag; //적어도 하나의 재료는 사용해야 한다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		isSelected = new boolean[N];
		min = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		subset(0);
		System.out.println(min);
		
	}
	
	public static void subset(int cnt) {
		if (cnt == N) {
			flag = false;
			s = 1;
			b = 0;
			for (int i=0; i<N; i++) {
				if (isSelected[i]) {
					flag = true;
					s = s * sour[i];
					b = b + bitter[i];
				}
			}
			if (flag == false) { //한개도 고르지 않았다면 무효
				return;
			}
			result = Math.abs(s-b);
			if (result < min) {
				min = result;
			}
			return;
		}
		
		else {
			isSelected[cnt] = true; //cnt번째 입력을 부분집합에 포함
			subset(cnt+1);
			isSelected[cnt] = false; //cnt번째 입력을 부분집합에 포함X
			subset(cnt+1);
		}
	}

}
