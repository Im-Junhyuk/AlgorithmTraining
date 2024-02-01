import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static boolean[] isSelected;
	static int[] result;
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		isSelected = new boolean[n+1];
		result = new int[m];
		perm(0);
		System.out.println(sb);
	}
	
	public static void perm(int cnt) {
		if (cnt == m) {
			for (int i=0; i<cnt; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		else {
			for (int i=1; i<n+1; i++) {
				if (!(isSelected[i])) {
					result[cnt] = i;
					isSelected[i] = true;
					perm(cnt+1);
					isSelected[i] = false;
				}
			}
		}
	}
}
