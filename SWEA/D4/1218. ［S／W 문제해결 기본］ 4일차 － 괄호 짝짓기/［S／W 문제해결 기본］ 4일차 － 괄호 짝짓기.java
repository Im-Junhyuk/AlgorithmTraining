import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Solution {

	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc < 11; tc++) {
	
			int stringLength = Integer.parseInt(br.readLine()); 
			String paren = br.readLine();
			Stack<Character> stack= new Stack<>();
			int valid = 1;
			
			for(int c = 0; c < stringLength; c++) {
				char curC = paren.charAt(c);
				if(curC == ')' || curC == '>' || curC == ']' || curC == '}') { 
					if(isDiffrent(stack.pop(), curC)) {
						valid = 0;
						break;
					}
				} else 
					stack.add(curC);
			
			}
			System.out.println("#" + tc + " " + valid);
		}
	}
	
	static boolean isDiffrent(char p1, char p2) {
		if(p1 == '<' && p2 == '>')
			return false;
		if(p1 == '{' && p2 == '}')
			return false;
		if(p1 == '(' && p2 == ')')
			return false;
		if(p1 == '[' && p2 == ']')
			return false;
		return true;
		
	}
}
