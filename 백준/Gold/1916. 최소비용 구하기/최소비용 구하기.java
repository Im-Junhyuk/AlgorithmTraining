import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		for(int n = 0; n <= N; n++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Node(start, end, dist));
		}
		
		st = new StringTokenizer(br.readLine());
		int sp = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> (n1.dist - n2.dist));
		for(Node n : graph.get(sp)) {
			pq.add(n);
		}
		
		boolean[] visited = new boolean[N+1];
		visited[sp] = true;
		while(!pq.isEmpty()) {
			Node curV = pq.poll();
			
			if(curV.end == dest) {
				System.out.println(curV.dist);
				return;
			}
			if(visited[curV.end] == true)
				continue;
			visited[curV.end] = true;
			
			for(Node next : graph.get(curV.end)) {
				if(visited[next.end] == false) {
					pq.add(new Node(0, next.end, curV.dist + next.dist));
				}
			}
		}
	}
	
	static class Node{
		int dist; 
		int start;
		int end;
		Node(int start, int end, int dist){
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
	}
}
