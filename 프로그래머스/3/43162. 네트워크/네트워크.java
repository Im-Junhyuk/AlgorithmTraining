class Solution {
    
    int answer;
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n];
        answer = 0;
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                dfs(i, visited, computers);    
        }   
        }
       
        return answer;
    }
    
    void dfs(int i, boolean[] visited, int[][] computers){
        if(visited[i])
            return;
        
        visited[i] = true;
        
        for(int k = 0; k < computers.length; k++){
            if(computers[i][k] == 1)
                dfs(k, visited, computers);
        }
    }
}