import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Point> points = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(points, (p1, p2) -> {
			if (p1.y != p2.y) 
				return p1.y - p2.y;
			else {
				return p1.x - p2.x;
			}});
		for(int i = 0; i < points.size(); i++) {
			System.out.println(points.get(i).toString());
		}
		
	}
}

class Point{
	int x; 
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
}