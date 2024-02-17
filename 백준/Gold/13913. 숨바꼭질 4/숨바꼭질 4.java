import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	

	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] field = new int[100002];
		for(int i = 0; i < field.length-1; i++) {
			field[i] = -1;
		}
		
		Queue<Subin> q = new LinkedList<Subin>();
		q.add(new Subin(N, -2, 0));
		int catchTime = 0;
		
		while(!q.isEmpty()) {
			Subin cur = q.poll();
			if(field[cur.position] != -1)
				continue;
			
			field[cur.position] = cur.pre;
			
			if(cur.position == K) {
				catchTime = cur.time;
				break;
			}
			
			if(cur.position-1 >= 0 && field[cur.position-1] == -1) 
				q.add(new Subin(cur.position-1, cur.position, cur.time + 1));
			
			if(cur.position+1 <= 100001 && field[cur.position+1] == -1) 
				q.add(new Subin(cur.position+1, cur.position, cur.time + 1));
			
			if(cur.position * 2 <= 100001 && field[cur.position*2] == -1) 
				q.add(new Subin(cur.position*2, cur.position, cur.time + 1));
			
		}
		
		sb.append(catchTime)
			.append("\n");
		Stack<Integer> temp = new Stack<Integer>();
		int curV = K;
		while(curV != -2) {
			temp.add(curV);
			curV = field[curV];
		}
		
		while(!temp.isEmpty()) {
			sb.append(temp.pop())
				.append(" ");
		}
		
		System.out.println(sb);
	}
	
	static class Subin{
		int position;
		int pre;
		int time;
		
		Subin(int position, int pre, int time) {
			this.position = position;
			this.pre = pre;
			this.time = time;
		}
	}
}