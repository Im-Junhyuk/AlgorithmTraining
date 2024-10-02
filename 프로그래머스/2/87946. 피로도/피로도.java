class Solution {
    
    int[][] dungeonInfo;
    int hp;
    
    int maxDepth;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        hp = k;
        dungeonInfo = dungeons;
        maxDepth = 0;
        visited = new boolean[dungeons.length];
        
        permutation(0);
        
        return maxDepth;
    }
    
    void permutation(int depth){
        // check score max
        
        maxDepth = Math.max(maxDepth, depth);
        
        // check depth
        
        if(maxDepth == dungeonInfo.length){
            return;
        }
        
        // permu
        
        for(int i = 0; i < dungeonInfo.length; i++){
            // go
            if(visited[i])
                continue;
            
            if(hp < dungeonInfo[i][0])
                continue;
            
            visited[i] = true;
            hp -= dungeonInfo[i][1];
            
            permutation(depth+1);
            
            //back
            
            visited[i] = false;
            hp += dungeonInfo[i][1];
        }
    }
}