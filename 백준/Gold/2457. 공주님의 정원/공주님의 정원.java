import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Flower[] flowers = new Flower[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			flowers[i] = new Flower(new Day(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())),
									new Day(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Arrays.sort(flowers);
		
		boolean ok = true;
		
		Day endDay = new Day(3, 1);
		int flowerNum = 0;
		Day lastDay = new Day(11, 30);
		int cur = 0;
		
		if(flowers[0].start.compareTo(endDay) > 0) {
			System.out.println(0);
			return;
		}
		
		while(endDay.compareTo(lastDay) <= 0) {
			int candidateIndex = cur;
			Day candidateEndDay = flowers[cur].end;
			cur++;
			
			while(cur < N && flowers[cur].start.compareTo(endDay) <= 0 ) {
				if(candidateEndDay.compareTo(flowers[cur].end) < 0) {
					candidateIndex = cur;
					candidateEndDay = flowers[cur].end;
				}
				cur++;
			}
			
			if(endDay.month == candidateEndDay.month && endDay.day == candidateEndDay.day) {
				ok = false;
				break;
			}
			
			flowerNum++;
			endDay = flowers[candidateIndex].end;
			cur = candidateIndex;
		}
		
		if(ok)
			System.out.println(flowerNum);
		else 
			System.out.println(0);
		
		
	}
	static class Flower implements Comparable<Flower>{
		Day start;
		Day end;
		public Flower(Day start, Day end) {
			this.start = start;
			this.end = end;
			
		}
		@Override
		public int compareTo(Flower o) {
			return this.start.compareTo(o.start);
		}
		
	}
	
	static class Day implements Comparable<Day>{
		int month;
		int day;
		Day(int month, int day){
			this.month = month;
			this.day = day;
		}
		@Override
		public int compareTo(Day o) {
			if(this.month != o.month)
				return this.month - o.month;
			else 
				return this.day - o.day;
			
		}
	}
}
