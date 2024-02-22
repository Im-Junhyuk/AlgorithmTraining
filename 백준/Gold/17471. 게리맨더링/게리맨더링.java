import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static ArrayList<Integer>[] graph;
	static int[] visited;
	static int[] population;
	
	static int minPopulationGap;
	static boolean[] temp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		population = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int n = 1; n <= N; n++) {
			population[n] = Integer.parseInt(st.nextToken());
		}
		
		for(int n = 1; n <= N; n++) {
			graph[n] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			for(int v = 0; v < V; v++) {
				graph[n].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// figure out how many partition here.
		
		visited = new int[N+1];
		int region = 0;
		for(int n = 1; n <= N; n++) {
			if(visited[n] == 0) {
				region++;
				dfs(n, region);
			}
		}
		
		// handling cases for 2 more partiton
		
		if(region >= 3) {
			System.out.println(-1);
			return;
		} else if(region == 2) {
			int p1 = 0;
			int p2 = 0;
			
			for(int n = 1; n <= N; n++) {
				if(visited[n] == 1)
					p1 += population[n];
				else
					p2 += population[n];
			}
			System.out.println(Math.abs(p1-p2));
			return;
		}
			
		// unfortunately there only 1 partition. make 2 and validation.
		
		minPopulationGap = Integer.MAX_VALUE;
		temp = new boolean[N+1];
		for(int regionNum = 1; regionNum <= N/2; regionNum++) {
			combination(1, 0, regionNum);
		}
		
		System.out.println(minPopulationGap);
		
	}
	static void dfs(int cur, int region) {
		visited[cur] = region;
		for(int i : graph[cur])
			if(visited[i] == 0)
				dfs(i, region);
	}

	static void combination(int start, int len, int regionNum) {
		if(regionNum == len) {
//			System.out.println(Arrays.toString(temp));
			if(validCheck()) {
				populationCheck();
//				System.out.println(len + " " + minPopulationGap);
			}
			return;
		}
		
		for(int i = start; i < N+1; i++) {
			temp[i] = true;
			combination(i+1, len+1, regionNum);
			temp[i] = false;
		}
	}
	
	// check that 2 partition are connected respectively
	static boolean validCheck() {
		int region = 0;
		visited = new int[N+1];
		for(int n = 1; n <= N; n++) {
			if(visited[n] == 0) {
				region++;
				dfs2(n, region);
			}
		}
		if(region == 2)
			return true;
		else
			return false;
	}
	
	static void dfs2(int cur, int region) {
		visited[cur] = region;
		for(int i : graph[cur])
			if(visited[i] == 0 && temp[cur] == temp[i])
				dfs2(i, region);
	}
	
	// get a population gap of two valid partition and update
	static void populationCheck() {
		int p1 = 0;
		int p2 = 0;
		
		for(int n = 1; n <= N; n++) {
			if(temp[n])
				p1 += population[n];
			else
				p2 += population[n];
		}
//		System.out.println("p1 " + p1 + " p2 " + p2);
		minPopulationGap = Math.min(Math.abs(p1-p2), minPopulationGap);
	}
}
