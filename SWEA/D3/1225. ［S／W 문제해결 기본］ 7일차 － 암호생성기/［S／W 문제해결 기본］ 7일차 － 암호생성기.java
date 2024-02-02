import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static Queue<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc < 11; tc++) {
			int testCase = Integer.parseInt(br.readLine());
			
			q = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			cycle();
			
			sb.append("#" + tc + " ");
			int qSize = q.size();
			for(int i = 0; i < qSize; i++) {
				sb.append(q.poll() + " ");
			}
			sb.append("\n");
		}
	
		System.out.println(sb);
	}
	
	static void cycle() {
		while(true) {
			for(int i = 1; i < 6; i++) {
				int one = q.poll();
				one -= i;
				if(one <= 0) {
					one = 0;
					q.add(one);
					return;
				}
				q.add(one);
			}
		}
	}

}
