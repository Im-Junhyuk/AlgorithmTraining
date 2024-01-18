
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			hashMap.put(st.nextToken(), st.nextToken());
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String site;
		for (int i = 0; i < M; i++) {
			site = br.readLine();
			bw.write(hashMap.get(site) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
