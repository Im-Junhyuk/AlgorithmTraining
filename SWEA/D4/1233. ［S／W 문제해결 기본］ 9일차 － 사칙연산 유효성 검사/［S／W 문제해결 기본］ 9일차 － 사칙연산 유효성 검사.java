import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static Set<String> op = new HashSet<>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		op.add("+");
		op.add("-");
		op.add("*");
		op.add("/");
		
		for(int tc = 1; tc < 11; tc++) {
			sb.append("#")
			.append(tc)
			.append(" ");
			
			int N = Integer.parseInt(br.readLine()); 
			String[] graph = new String[N+1];
			
			for(int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				graph[v] = st.nextToken();
			}
			
			sb.append(check(graph))
			.append("\n");
			
		}
        System.out.println(sb);

	}
	
	static int check(String[] strArr) {
		for(int i = 1; i < strArr.length; i++) {
			if(i <= (strArr.length - 1) / 2) {
				if(!op.contains(strArr[i]))
					return 0;
			} else if(op.contains(strArr[i]))
				return 0;
		}
		return 1;
	}
}
