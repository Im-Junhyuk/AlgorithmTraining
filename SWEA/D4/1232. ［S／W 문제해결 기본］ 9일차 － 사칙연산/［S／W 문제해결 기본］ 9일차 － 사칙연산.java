import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution {

	static String[] data;
	static int[] left;
	static int[] right;
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> op = new HashSet<>();
		op.add("+");
		op.add("-");
		op.add("*");
		op.add("/");
		
		for(int tc = 1; tc < 11; tc++) {
			sb.append("#")
				.append(tc)
				.append(" ");
			
			int N = Integer.parseInt(br.readLine());
			data = new String[N+1];
			left = new int[N+1];
			right = new int[N+1];
			
			for(int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				if(op.contains(value)) {
					data[v] = value;
					left[v] = Integer.parseInt(st.nextToken());
					right[v] = Integer.parseInt(st.nextToken());
				} else {
					data[v] = value;
				}
				
			}
			
			sb.append(calculate(1))
				.append("\n");
			
			
			
			
		}
		
		System.out.print(sb);
	
	}
	
	static int calculate(int v) {
		if(left[v] == 0)
			return Integer.parseInt(data[v]);
		
		int leftNum = calculate(left[v]);
		int rightNum = calculate(right[v]);
		
		int num;
		
		switch (data[v]) {
		case ("+"):
			return leftNum + rightNum;
		case ("-"):
			return leftNum - rightNum;
		case ("*"):
			return leftNum * rightNum;
		case ("/"):
			return leftNum / rightNum;
		}
		
		return 0;
	}
}
