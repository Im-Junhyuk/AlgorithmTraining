import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int subin = sc.nextInt(); // 0 <= su <= 100000
		int bro = sc.nextInt();
		
		int time = 0;
		int[] visited = new int[100001];
		for(int i = 0; i < 100001; i++)
			visited[i] = -1;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(subin);
		visited[subin] = time;
		
		int curPosition = subin;
		int nextPosition;
		
		while(!q.isEmpty()) {
			curPosition = q.poll();

			time = visited[curPosition] + 1;

			if (curPosition == bro)
				break;
			
			nextPosition = curPosition - 1;
			if (nextPosition >= 0 && visited[nextPosition] == -1) {
				q.add(nextPosition);
				visited[nextPosition] = time;
			}
			
			nextPosition = curPosition + 1;
			if (nextPosition < 100001 && visited[nextPosition] == -1) {
				q.add(nextPosition);
				visited[nextPosition] = time;
			}
			
			nextPosition = curPosition * 2;
			if (nextPosition < 100001 && visited[nextPosition] == -1) {
				q.add(nextPosition);
				visited[nextPosition] = time;
			}
			
		}
		
		System.out.println(visited[curPosition]);
	}
}

