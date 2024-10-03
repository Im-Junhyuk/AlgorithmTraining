import java.io.*;
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        Set<Integer>[] dp = new HashSet[9];
        for(int i = 1; i < 9; i++){
            dp[i] = new HashSet<>();
            int k = 0;
            for(int j = 0; j < i; j++){
                k += Math.pow(10, j);
            }
            dp[i].add(k * N);
            if(k*N == number)
                return i;
            
            for(int j = 1; j <= i / 2; j++){
                for(int n1 : dp[j]){
                    for(int n2 : dp[i - j]){
                        dp[i].add(n1+n2);
                        dp[i].add(n1-n2);
                        dp[i].add(n2-n1);
                        dp[i].add(n1*n2);
                        if(n2 != 0)
                            dp[i].add(n1/n2);
                        if(n1 != 0)
                            dp[i].add(n2/n1);
                    }
                }
            }
            
            for(int n : dp[i]){
                if(n == number)
                    return i;
            }
            
        }
        
        return answer;
    }
}