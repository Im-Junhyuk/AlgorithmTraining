import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    	int v = Integer.parseInt(br.readLine());
    	int e = Integer.parseInt(br.readLine());
    	int len = v + 1;
    	int[][] edge = new int[len][len];
    	
    	for(int i = 0; i<e; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int v1 = Integer.parseInt(st.nextToken());
    		int v2 = Integer.parseInt(st.nextToken());
    		edge[v1][v2] = 1;
    		edge[v2][v1] = 1;
    	}
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.add(1);
    	int[] visited = new int[len];
    	int addicted = -1;
    	
    	while(q.isEmpty() == false) {
    		int cur_v = q.poll();
    		if (visited[cur_v] == 1)
    			continue;
    		visited[cur_v] = 1;
    		addicted++;
    		
    		for(int i = 0; i < len; i++) {
    			if (edge[cur_v][i]== 1 && visited[i]== 0) {
    				q.add(i);
    			}
    		}
    	}
    	System.out.println(addicted);
    }
}
