import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int maxRow = 0;
        int maxCol = 0;
        int num = sizes.length;
        
        for(int[] cur : sizes){
            if(cur[0] < cur[1]){
                int k = cur[0];
                cur[0] = cur[1];
                cur[1] = k;
            }
            
            maxRow = Math.max(maxRow, cur[0]);
            maxCol = Math.max(maxCol, cur[1]);
        }
        
        int answer = maxRow * maxCol;
        System.out.println(answer);
        return answer;
    }
}