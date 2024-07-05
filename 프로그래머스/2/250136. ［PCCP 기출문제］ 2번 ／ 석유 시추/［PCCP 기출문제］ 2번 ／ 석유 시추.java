import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] land) {

        ArrayList<Integer> oilGroups = new ArrayList<>();
        oilGroups.add(0);
        oilGroups.add(0);
        
        // dfs
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j] == 1){
                    oilGroups.add(dfs(land, i, j, 0, oilGroups.size()));
                }
            }
        }
        
        // for(int i = 0; i < land.length; i++){
        //     for(int j = 0; j < land[0].length; j++){
        //         System.out.print(land[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // for(int i = 0; i < oilGroups.size(); i++){
        //     System.out.print(oilGroups.get(i) + " ");
        // }
        
        // search
        int maxValue = 0;
        Set<Integer> tempSet = null;
        
        for(int j = 0; j < land[0].length; j++){
            tempSet = new HashSet<Integer>();
            for(int i = 0; i < land.length; i++){
                tempSet.add(land[i][j]);
            }
            
            int tempOil = 0;
            for(int o : tempSet){
                tempOil += oilGroups.get(o);
            }
            
            maxValue = Math.max(tempOil, maxValue);
        }
        return maxValue;
    }
    
    int dfs(int[][] land, int i, int j, int oil, int num){
        land[i][j] = num;
        oil++;
        
        for(int d = 0; d < 4; d++){
            int ni = i + dx[d];
            int nj = j + dy[d];
            
            if(ni < 0 || ni >= land.length || nj < 0 || nj >= land[0].length){
                continue;
            }
            
            if(land[ni][nj] == 1){
                oil = dfs(land, ni, nj, oil, num);
            }
        }
        
        return oil;
    }
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
}