import java.io.*;
import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        Set<Integer>[] puddleSet = new HashSet[n];
        for(int i = 0; i < n; i++){
            puddleSet[i] = new HashSet<>();    
        }
        
        for(int[] cur : puddles){
            puddleSet[cur[1]-1].add(cur[0]-1);
        }
        
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++){
            if(puddleSet[i].contains(0))
                break;
            dp[i][0] = 1;
        }
        
        for(int j = 0; j < m; j++){
            if(puddleSet[0].contains(j))
                break;
            dp[0][j] = 1;
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(puddleSet[i].contains(j))
                    continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= 1000000007;
            }
        }
        return dp[n-1][m-1];
    }
}