import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] map;
	
	static ArrayList<Point> people;
	static ArrayList<Point> stair;
	
	static int minTime;
	static int curMinTime;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			people = new ArrayList<Point>();
			stair = new ArrayList<Point>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)
						people.add(new Point(i, j));
					else if(map[i][j] > 1) 
						stair.add(new Point(i, j, map[i][j]));
				}
			}
			
			minTime = Integer.MAX_VALUE;
			for(int subSet = 0; subSet < (1<<people.size()); subSet++) {
				curMinTime = 0;
				simulation(subSet);
//				minTime = curMinTime;
				for(int i = 0; i < people.size(); i++) {
					people.get(i).stayingTime = 0;
				}
				minTime = Math.min(minTime, curMinTime);
			}
			sb.append("#")
				.append(t)
				.append(" ")
				.append(minTime)
				.append("\n");
		}
		System.out.println(sb);
	}
	
	
	static void simulation(int subset) {
		PriorityQueue<Point> pq1 = new PriorityQueue<Point>();
		PriorityQueue<Point> pq2 = new PriorityQueue<Point>();
		
		
		for(int i = 0; i < people.size(); i++) {
			if( ((1<<i) & subset) == 0) {
				people.get(i).arrivalTime = Math.abs(stair.get(0).x-people.get(i).x) + Math.abs(stair.get(0).y-people.get(i).y);
				pq1.add(people.get(i));
			} else {
				people.get(i).arrivalTime = Math.abs(stair.get(1).x-people.get(i).x) + Math.abs(stair.get(1).y-people.get(i).y);
				pq2.add(people.get(i));
			}
		}
		Queue<Point> s1 = new LinkedList<Point>();
		Queue<Point> s2 = new LinkedList<Point>();
		
		int arrival = 0;
		while(arrival < people.size()) {
			
			int size1 = s1.size();
			for(int i = 0; i < size1; i++) {
				Point cur = s1.poll();
				cur.stayingTime++;
				if(cur.stayingTime < stair.get(0).stayingTime) 
					s1.add(cur);
				else 
					arrival++;
				
			}
			
			int size2 = s2.size();
			for(int i = 0; i < size2; i++) {
				Point cur = s2.poll();
				cur.stayingTime++;
				
				if(cur.stayingTime < stair.get(1).stayingTime) 
					s2.add(cur);
				else
					arrival++;
			}
			
			while(s1.size() < 3 && pq1.peek() != null && pq1.peek().arrivalTime <= curMinTime) 
				s1.add(pq1.poll());
			
			while(s2.size() < 3 && pq2.peek() != null && pq2.peek().arrivalTime <= curMinTime) 
				s2.add(pq2.poll());
			
			curMinTime++;
//			if(curMinTime >= minTime)
//				return;
		}
	}
	
	static class Point implements Comparable<Point>{
		int x; 
		int y;
		int arrivalTime;
		int stayingTime;
		Point(int x, int y){
			this.x = x;
			this.y = y;
			arrivalTime = 0;
			stayingTime = 0;
		}
		Point(int x, int y, int time){
			this.x = x;
			this.y = y;
			arrivalTime = 0;
			stayingTime = time;
		}
		@Override
		public int compareTo(Point o) {
			return this.arrivalTime-o.arrivalTime;
		}
	}
}