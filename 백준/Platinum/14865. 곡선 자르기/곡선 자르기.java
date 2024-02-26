import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] points = new int[N][2];
		
		int minX = Integer.MAX_VALUE;
		int fX = 0;
		int fY = 0;
		int fI = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			points[i][0] = x;
			points[i][1] = y;
			if(x < minX) {
				fX = x;
				fY = y;
				fI = i; // starting point 
				minX = x;
			}
		}
		
		
		// positive is 1, nagative is -1
		// 0 mean no v before, 1 means having 1 v already. be 2, make a hill and reset.
		
		int sp = 0;
		for(int i = 0; i < N; i++) {
			if(points[i][0] == points[(i+1)%N][0])
				if(points[i][1] < 0 && points[(i+1)%N][1] > 0) {
					sp = i;
					break;
				}
		}
		
		ArrayList<Hill> hills = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		boolean state = false; // under
		
		// hill find and add to hills
		for(int i = 0; i < N; i++) {
//			System.out.println(points[sp][0] + " " + points[sp][1]);
			if( ( points[sp][1] > 0 && points[(sp+1)%N][1] < 0) 
					|| (points[sp][1] < 0 && points[(sp+1)%N][1] > 0) ) { // hill v
				if(temp.size() == 0)
					temp.add(points[sp][0]);
				else if(temp.size() == 1) {
					if(temp.get(0) > points[sp][0])
						hills.add(new Hill(points[sp][0], temp.get(0)));
					else 
						hills.add(new Hill(temp.get(0), points[sp][0]));
					temp = new ArrayList<>();
				}
				
			}
			sp = (sp+1) %N; 
		}
		Collections.sort(hills);
		int notContainingHill = 0;
		int notContainedHill = 0;
		
//		System.out.println(hills.size());
		Stack<Hill> hillStack = new Stack<>();
		for(int i = 0; i < hills.size(); i++) {
			
			while(!hillStack.isEmpty()) {
				if(hillStack.peek().e> hills.get(i).s)
					break;
				else {
					Hill h = hillStack.pop();
					if(h.containing == false)
						notContainingHill++;
				}
			}
			if(hillStack.isEmpty()) {
				notContainedHill++;
			} else {
				hillStack.peek().containing = true;
			}
			hillStack.add(hills.get(i));
		}
		
//		while(!hillStack.isEmpty()) {
//			Hill h = hillStack.pop();
//			
//		}
		
		// stack remanining
		if(!hillStack.isEmpty())
			if(hillStack.peek().containing == false)
				notContainingHill++;
		
		System.out.println(notContainedHill + " " + notContainingHill);
	}
	static class Hill implements Comparable<Hill>{
		int s;
		int e;
		boolean containing;
		Hill(int s, int e){
			this.s = s;
			this.e = e;
			containing = false;
		}
		@Override
		public int compareTo(Hill o) {
			return this.s - o.s;
		}
	}
}
