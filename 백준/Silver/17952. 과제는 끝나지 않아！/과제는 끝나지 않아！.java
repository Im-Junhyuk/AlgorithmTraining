import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Stack<Work> workStack = new Stack<>();
		int totalScore = 0;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int inst = Integer.parseInt(st.nextToken());
			if(inst == 1) {
				workStack.add(new Work(Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken())));
			}
				
			if(!workStack.isEmpty()) {
				if(workStack.peek().remainTime == 1)
					totalScore += workStack.pop().score;
				else
					workStack.peek().remainTime--;
			}
				
		}
		System.out.println(totalScore);
	}
	static class Work{
		int score;
		int remainTime;
		Work(int score, int remainTime){
			this.score = score;
			this.remainTime = remainTime;
		}
	}
}
