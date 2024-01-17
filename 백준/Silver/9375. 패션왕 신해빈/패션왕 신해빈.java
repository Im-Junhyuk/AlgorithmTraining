import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < tc; testCase++) {
			int cloth = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			StringTokenizer st;
			String key;
			String value;
			
			for(int i = 0; i < cloth; i++) {
				st = new StringTokenizer(br.readLine());
				value = st.nextToken();
				key = st.nextToken();
				if(hm.containsKey(key)) {
					hm.put(key, hm.get(key) + 1);
				} else {
					hm.put(key, 1);
				}
			}
			
			int combi = 1;
			for (Integer i : hm.values()) {
				combi *= (i + 1);
			}
			System.out.println(combi-1);
		}
	}
}