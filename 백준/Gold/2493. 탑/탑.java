import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] tower = new int[N];
		
		for(int i = 0; i < N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Node> stack = new Stack<>();
		int[] ans = new int[N];
		
		for(int i = N-1; i >= 0; i--) {

			int offset = 1;
			while(!stack.isEmpty() && tower[i] >= stack.peek().height) {
				Node node = stack.pop();
				ans[node.index] = i + 1;
			}
			stack.push(new Node(tower[i], i));
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(ans[i])
			.append(" ");
		}
		System.out.println(sb);
	}
	static class Node{
		int height;
		int index;
		
		Node(int height, int index){
			this.height = height;
			this.index = index;
		}
	}

}