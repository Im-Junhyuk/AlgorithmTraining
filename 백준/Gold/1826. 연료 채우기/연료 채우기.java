import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		GasStation[] gasStations = new GasStation[N+1];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dist = Integer.parseInt(st.nextToken());
			int fuel = Integer.parseInt(st.nextToken());
			
			gasStations[i] = new GasStation(dist, fuel);
		}
		st = new StringTokenizer(br.readLine());
		int dest = Integer.parseInt(st.nextToken());
		int curFuel = Integer.parseInt(st.nextToken());
		
		gasStations[N] = new GasStation(dest, 0);
		Arrays.sort(gasStations, (g1, g2) -> g1.dist - g2.dist);
		
		
		int gasStationCnt = 0;
//		int curDist = 0;
		PriorityQueue<GasStation> pq = new PriorityQueue<Main.GasStation>((g1, g2) ->
				g2.fuel - g1.fuel);
		
		
		for(int i = 0; i < N+1; i++) {
			if(curFuel >= dest)
				break;
			
			if(curFuel < gasStations[i].dist) {
				while(curFuel < gasStations[i].dist) {
					if(pq.isEmpty()) {
						System.out.println(-1);
						return;
					}
					
					curFuel += pq.poll().fuel;
//					System.out.println(gasStations[i].dist + " " + curFuel);
					gasStationCnt++;
				}
			}
			
			pq.add(gasStations[i]);
			
		}
		System.out.println(gasStationCnt);
	}
	
	static class GasStation{
		int dist;
		int fuel;
		
		GasStation(int dist, int fuel){
			this.dist = dist;
			this.fuel = fuel;
		}
	}
}