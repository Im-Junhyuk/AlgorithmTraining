import java.util.*;
import java.io.*;

class Solution {
    
    int len;
    Set<Integer> done;
    boolean[] primeList;
    int answer;
    boolean[] visited;
    int maxNum;
    StringBuilder sb;
    String nums;
    int digit;
    
    public int solution(String numbers) {
        
        nums = numbers;
        len = numbers.length();
        System.out.println(len);
        answer = 0;
        done = new HashSet<>();
        digit = numbers.length();
        maxNum = (int)Math.pow(10, digit);
        sb = new StringBuilder();
        visited = new boolean[digit];
        
        primeList = new boolean[maxNum];
        
        // System.out.println("prime start");
        // prime();
        // System.out.println("prime");
        permutation(0);
        
        
        System.out.println(answer);
        return answer;
    }
    
    public void prime(){
        primeList[0] = true;
        primeList[1] = true;
        
        for(int i = 2; i <= Math.sqrt(maxNum-1); i++){
            int cur = i;
            if(primeList[cur])
                continue;
            
            cur += i;
            while(cur < primeList.length){
                // if(cur > maxNum-1)
                //     break;
                primeList[cur] = true;
                cur =+ i;
            }
        }
    }
    
    public void permutation(int depth){
        if(depth != 0){
            String str = sb.toString();
            System.out.println(str);
            int curNum = Integer.valueOf(str);
            if(done.contains(curNum) == false){
                done.add(curNum);
                if(isPrime1(curNum))
                    answer++;
            }
        }
        
        if(depth == digit)
            return;
        
        for(int i = 0; i < digit; i++){
            if(visited[i] == false){
                visited[i] = true;
                sb.append(nums.charAt(i));
                
                permutation(depth+1);
                
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public boolean isPrime1(int num){
        if(num <= 1){
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i == 0)
                return false;
        }
        return true;
    }
    public boolean isPrime(int num){
        if(primeList[num])
            return false;
        return true;
    }
}