import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] parents;
	static long totalcost;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] xList = new int[N];
			int[] yList = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				xList[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				yList[i] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			ArrayList<Edge> edges = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					edges.add(new Edge(i, j, Math.pow(xList[i]-xList[j], 2) +Math.pow(yList[i]-yList[j], 2)));
				}
			}
			Collections.sort(edges, (e1, e2) -> (int)(e1.dist - e2.dist));
			parents = new int[N];
			for(int i = 0; i < N; i++) {
				parents[i] = i;
			}
			totalcost = 0;
			
			for(int i = 0; i < edges.size(); i++) {
				Edge e = edges.get(i);
				int p1 = find(e.start);
				int p2 = find(e.end);
				if(p1 == p2)
					continue;
				else {
					union(p1, p2);
					totalcost += e.dist;
				}
			}
			
			sb.append("#")
				.append(tc)
				.append(" ")
				.append(Math.round(totalcost * E))
				.append("\n");
			
		}
		System.out.println(sb);
	}
	static class Edge{
		int start;
		int end;
		double dist;
		Edge(int start, int end, double dist){
			this.start = start;
			this.dist = dist;
			this.end = end;
		}
	}
	
	static int find(int v) {
		if(v == parents[v])
			return v;
		else
			return parents[v] = find(parents[v]);
	}
	
	static void union(int v1, int v2) {
		if(v2 < v1)
			parents[v1] = v2;
		else
			parents[v2] = v1;
	}
}
