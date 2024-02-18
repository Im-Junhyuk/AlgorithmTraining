import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int time = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[][] visited = new boolean[2][500001];
		q.add(N);
		
		while(K <= 500000) {
			Queue<Integer> temp = new LinkedList<Integer>();
			while(!q.isEmpty()) {
				int cur = q.poll();

				visited[time%2][cur] = true;
				if(cur-1 >= 0 && visited[(time+1)%2][cur-1] == false)
					temp.add(cur-1);
				if(cur+1 <= 500000 && visited[(time+1)%2][cur+1] == false)
					temp.add(cur+1);
				if(cur*2 <= 500000 && visited[(time+1)%2][cur*2] == false)
					temp.add(cur*2);
			}
			if(visited[time%2][K]) {
				System.out.println(time);
				return;
			}
			q = temp;
			K += time +1;
			time++;
		}
		System.out.println(-1);
	}
}