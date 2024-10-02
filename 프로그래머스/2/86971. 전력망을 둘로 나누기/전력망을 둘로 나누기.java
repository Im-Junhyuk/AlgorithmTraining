import java.io.*;
import java.util.*;

class Solution {
    
    class Edge{
        int x;
        int y;
        Edge(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int n, int[][] wires) {
        int answer = 100;
        
        // edge to graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(null);
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < wires.length; i++){
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        // search
        for(int[] wire: wires){
            if(answer == 0)
                break;
            
            // calculataion
            Queue<Integer> q = new LinkedList<>();
            int temp = 1;
            boolean[] visited = new boolean[n+1];
            
            visited[wire[0]] = true;
            for(Integer i : graph.get(wire[0])){
                if(i == wire[1])
                    continue;
                
                q.add(i);
                temp++;
            }
            
            
            
            while(!q.isEmpty()){
                Integer cur = q.poll();
                visited[cur] = true;
                
                for(int i : graph.get(cur)){
                    if(visited[i])
                        continue;
                    
                    temp++;
                    q.add(i);
                }
            }
            
            answer = Math.min(answer, Math.abs(2 * temp - n));
        }
        
            
        return answer;
    }
}