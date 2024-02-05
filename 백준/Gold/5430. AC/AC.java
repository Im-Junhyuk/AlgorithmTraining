import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sbPrinter = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < TC; tc++) {
			AC();
		}
		System.out.println(sbPrinter);
	}
	
	public static void AC() throws IOException {
		String inst = br.readLine();
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(br.readLine());
		
		sb.deleteCharAt(0);
		sb.deleteCharAt(sb.length()-1);
		
		StringTokenizer st = new StringTokenizer(sb.toString(), ",");
		
		int stLen = st.countTokens();
		Deque<Integer> dq = new ArrayDeque<>();
		
		for(int i = 0; i < stLen; i++){
			dq.add(Integer.parseInt(st.nextToken()));
		}
		
		boolean reversed = false;
		for(int i = 0; i < inst.length(); i++) {
			if(inst.charAt(i) == 'D') {
				if(dq.size() == 0) {
					sbPrinter.append("error\n");
					return;
				}
				
				if(reversed == false) {
					dq.pollFirst();
				} else {
					dq.pollLast();
				}
			} else { 		//R
				reversed = !reversed;
			}
		}
		if(reversed == false) {
		sbPrinter.append("[");
		while(!dq.isEmpty()) {
			sbPrinter.append(dq.pollFirst());
			if(!dq.isEmpty()) {
				sbPrinter.append(",");
			}
		}
		sbPrinter.append("]\n");
		} else {
			sbPrinter.append("[");
			while(!dq.isEmpty()) {
				sbPrinter.append(dq.pollLast());
				if(!dq.isEmpty()) {
					sbPrinter.append(",");
				}
			}
			sbPrinter.append("]\n");
		}
	}
}
