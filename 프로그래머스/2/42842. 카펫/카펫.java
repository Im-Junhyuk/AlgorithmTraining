import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int entire = brown + yellow;
        
        for(int i = 1; i <= Math.sqrt(entire); i++){
            if(entire % i != 0){
                continue;
            }
            int col = i;
            int row = entire / col;
            
            if((row-2) * (col-2) == yellow){
                int[] answer = {row, col};
                return answer;
            }
        }
        int[] answer = {};
        return answer;
    }
}