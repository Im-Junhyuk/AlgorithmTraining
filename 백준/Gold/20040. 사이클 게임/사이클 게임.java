import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] vertics;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int vNum = Integer.parseInt(st.nextToken());
		int turn = Integer.parseInt(st.nextToken());
		
		vertics = new int[vNum];
		for(int i = 0; i <vNum; i++) {
			vertics[i] = i;
		}
		
		int fir;
		int sec;
		int curTurn = 0;
		for(int i = 1; i <= turn; i++) {
			st = new StringTokenizer(br.readLine());
			fir = Integer.parseInt(st.nextToken());
			sec = Integer.parseInt(st.nextToken());
			
			if(find(fir) == find(sec)) {
				curTurn = i;
				break;
			}
			else {
				union(fir, sec);
			}
		}
		
		System.out.println(curTurn);
	}
	
	static int find(int v) {
		while(true) {
			if (v == vertics[v])
				return v;
			else 
				v = vertics[v];
		}
	}

	static void union(int v1, int v2) {
		int v1Root = find(v1);
		int v2Root = find(v2);
		if (v1Root > v2Root)
			vertics[v1Root] = v2Root;
		else 
			vertics[v2Root] = v1Root;
	}
}