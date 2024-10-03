import java.io.*;
import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<String>();
        
        boolean[] visited = new boolean[words.length];
        
        q.add(begin);
        while(!q.isEmpty()){
            String cur = q.poll();
            Queue<String> temp = new LinkedList<>();
            
            if(isEqual(cur, target))
                return answer;
            
            for(int i = 0; i < words.length; i++){
                if(visited[i] == false && changable(cur, words[i])){
                    visited[i] = true;
                    temp.add(words[i]);
                }
            }
            
            if(q.isEmpty()){
                q = temp;
                answer++;
            }
        }
        
        return 0;
    }
    
    boolean changable(String s1, String s2){
        int diff = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                diff++;
            if(diff >= 2)
                return false;
        }
        
        if(diff == 1)
            return true;
        else
            return false;
    }
    
    boolean isEqual(String s1, String s2){
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }
}