import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Point> points = new ArrayList<Point>(N);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			points.add(new Point(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
					));
		}
		
		Collections.sort(points, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				if(o1.x != o2.x)
					return o1.x - o2.x;
				else
					return o1.y - o2.y;
			}
		});
		for (int i = 0; i < points.size(); i++)
			System.out.println(points.get(i).toString());
	}
	static class Point{
		public int x;
		public int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x + " " + y;
		}
		
	}
}
