import java.io.*;
import java.util.*;

class Solution {
    
    static int[] s1 = {1, 2, 3, 4, 5};
    static int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] s3 = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        
        int[] scores = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            if(s1[i % s1.length] == answers[i])
                scores[0]++;
            if(s2[i % s2.length] == answers[i])
                scores[1]++;
            if(s3[i % s3.length] == answers[i])
                scores[2]++;
        }
        
        int maxS = 0;
        for(int i = 0; i < 3; i++){
            maxS = Math.max(maxS, scores[i]);
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            System.out.print(scores[i] + " ");
            if(scores[i] == maxS)
                temp.add(i+1);
        }
        int[] result = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            result[i] = temp.get(i);
        }
        
        
        return result;
    }
}