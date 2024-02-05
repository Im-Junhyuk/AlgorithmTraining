import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Node head = new Node(1);
		Node curNode = head;
		for(int i = 2; i < N+1; i++) {
			Node newNode = new Node(i);
			newNode.pre = curNode;
			curNode.next = newNode;
			curNode = newNode;
		}
		
		curNode.next = head;
		head.pre = curNode;
		
		curNode = head;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(true) {
			for(int i = 0; i < K - 1; i++) {
				curNode = curNode.next;
			}
			sb.append(curNode.data);
			if(curNode.data == curNode.next.data)
				break;
			
			sb.append(", ");
			curNode.pre.next = curNode.next;
			curNode.next.pre = curNode.pre;
			curNode = curNode.next;
		}
		sb.append(">");
		System.out.println(sb);
	}
	
	static class Node{
		int data;
		Node pre;
		Node next;
		
		Node(int data){
			this.data = data;
			pre = null;
			next = null;
		}
	}

}
