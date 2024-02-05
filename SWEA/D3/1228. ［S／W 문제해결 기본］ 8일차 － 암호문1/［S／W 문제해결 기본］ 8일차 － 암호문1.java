import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Solution
{

	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;


		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			LinkedList linkedList = new LinkedList();
			int cryptoNum = Integer.parseInt(st.nextToken());
			int[] s = new int[cryptoNum];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < cryptoNum; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			linkedList.add(cryptoNum, s);
			
			int instNum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < instNum; i++) {

				String inst = st.nextToken();
				int x, y;
				int list[];
				switch (inst) {
					case "I": 
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());
						list = new int[y];
						for(int j = 0; j < y; j++) {
							list[j] = Integer.parseInt(st.nextToken());
						}
						linkedList.insert(x, y, list);
						break;
				}
				

			}
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write("#" + test_case + " " + linkedList.get10Nodes() + "\n");
			bw.flush();

		}
	}

	public static class LinkedList{
		Node head;
		Node tail;

		
		public LinkedList() {
			head = null;
			tail = null;
		}
		
		public Node getNode(int info) {
			return new Node(info);
		}
		
		public void insert(int x, int y, int[] s) {

			int start = 0;
			
			if(x == 0) {
				Node curNode = getNode(s[0]);
				curNode.next = head;
				head = curNode;
				start++;
				x++;
			}
			
			Node startNode = head;
			for(int idx = 1; idx < x; idx++) {
				startNode = startNode.next;
			}
			
			Node linkNode = startNode.next;
			
			for(; start < y; start++) {
				Node curNode = getNode(s[start]);
				startNode.next = curNode;
				startNode = curNode;
			}
			
			startNode.next = linkNode;
			if(startNode.next == null)
				tail = startNode;
		}
		
		public void add(int y, int[] s) {
			int index = 0;
			Node curNode;
			if(head == null) {
				curNode = getNode(s[index]);
				head = curNode;
				tail = curNode;
				index++;
			}
			for(; index < y; index++) {
				curNode = getNode(s[index]);
				tail.next = curNode;
				tail = curNode;
			}
		}
		
		public String get10Nodes() {
			Node curNode = head;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 10; i++) {
				sb.append(curNode.info + " ");
				curNode = curNode.next;
			}
			return sb.toString();
		}
	}
	
	public static class Node{
		int info;
		Node next;
		
		public Node(int info) {
			this.info = info;
			this.next = null;
		}
	}
}
