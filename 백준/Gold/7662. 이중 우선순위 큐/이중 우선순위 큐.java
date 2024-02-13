import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main{

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			
			
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			
			for(int inst = 0; inst < k; inst++) {
				st = new StringTokenizer(br.readLine());
			
				String instruction = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				switch (instruction) {
				case "I":
					if(treeMap.containsKey(num)) {
						treeMap.replace(num, treeMap.get(num)+1);
					} else {
						treeMap.put(num, 1);
					}
					break;
				case "D":

					if(treeMap.isEmpty()) 
						continue;
					
					Map.Entry<Integer, Integer> entry;
					if(num < 0) {
						entry = treeMap.firstEntry();
						if(entry.getValue() == 1)
							treeMap.remove(entry.getKey());
						else
							treeMap.replace(entry.getKey(), entry.getValue()-1);
					} else {
						entry = treeMap.lastEntry();
						if(entry.getValue() == 1)
							treeMap.remove(entry.getKey());
						else
							treeMap.replace(entry.getKey(), entry.getValue()-1);
					}
					
					
				}
			}
			
			
			if(treeMap.isEmpty())
				System.out.println("EMPTY");
			else
				System.out.println(treeMap.lastEntry().getKey() + " " + treeMap.firstEntry().getKey());
			
		}
	
	}
	
}