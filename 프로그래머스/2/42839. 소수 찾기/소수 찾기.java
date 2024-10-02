import java.util.*;
import java.io.*;

class Solution {
    
    int len;
    Set<Integer> done;
    boolean[] primeList;
    int answer;
    boolean[] visited;
    
    public int solution(String numbers) {
        
        len = numbers.length();
        System.out.println(len);
        answer = 0;
        done = new HashSet<>();
        int digit = numbers.length();
        
        System.out.print(digit + " , " + Math.pow(10, digit));
        primeList = new boolean[(int)Math.pow(10, digit)];
        // prime();
        // permutation();
        
        
        return answer;
    }
    
    public void prime(){
        primeList[0] = true;
        primeList[1] = true;
        
        for(int i = 2; i <= Math.sqrt(9999999); i++){
            int cur = i;
            while(true){
                cur =+ i;
                if(cur > 9999999)
                    break;
                primeList[cur] = true;
                
            }
        }
    }
    
    public void permutation(){
        
    }
    
    public boolean isPrime(int num){
        if(primeList[num])
            return false;
        return true;
    }
}