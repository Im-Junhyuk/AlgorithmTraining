import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parents;
	static int[] member;
	static Map<String, Integer> id;
	static int num;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < TC; tc++) {
			
			int F = Integer.parseInt(br.readLine());
			num = 0;
			id = new HashMap<>();
			
			member = new int[200000];
			parents = new int[200000];
			
			for(int f = 0; f < F; f++) {
				st = new StringTokenizer(br.readLine());
				int cur[] = new int[2];
				for(int i = 0; i < 2; i++) {
					String name = st.nextToken();
					cur[i] = add(name);
				}
				union(find(cur[0]), find(cur[1]));
			}
		}
		
		
		
	}
	
	static int add(String name) {
		if(id.containsKey(name))
			return id.get(name);
		
		member[num] = 1;
		parents[num] = num;
		
		id.put(name, num);
		num++;
		return id.get(name);
	}
	static int find(int id) {
		if(id == parents[id])
			return id;
		
		return parents[id] = find(parents[id]);
	}
	
	static void union(int id1, int id2) {
		
		if(id1 > id2) {
			int temp = id2;
			id2 = id1;
			id1 = temp;
		}
		
		if(id1 != id2) {
		parents[id2] = id1;
		member[id1] += member[id2];
		}
		
		System.out.println(member[id1]);
	}
}

