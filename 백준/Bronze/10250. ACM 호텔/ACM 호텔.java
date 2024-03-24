import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int floor;
			if(N%H == 0)
				floor = H;
			else 
				floor = N%H;

			int room;
			if(N%H == 0)
				room = N/H;
			else 
				room = N/H+1;
			
			if(room >= 10)
				System.out.println(floor + "" + room);
			else 
				System.out.println(floor + "0" + room);
		}
	}
}

