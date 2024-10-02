import java.io.*;
import java.util.*;

class Solution {
    
    int cnt;
    int cur;
    int[] nums;
    int answer;
    
    public int solution(int[] numbers, int target) {
        cnt = 0;
        cur = 0;
        nums = numbers;
        answer = target;
        
        dfs(0);
        return cnt;
    }
    
    public void dfs(int depth){
        
        if(depth == nums.length){
            if(cur == answer){
                cnt++;
            }
            return;
        }
            
        cur += nums[depth];
        dfs(depth+1);
        cur -= nums[depth];
        
        cur-= nums[depth];
        dfs(depth+1);
        cur += nums[depth];
    }
    
}