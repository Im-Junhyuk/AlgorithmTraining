import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(arr[0]);
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] != arr[i])
                q.add(arr[i]);
        }
        
        int[] answer = new int[q.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = q.poll();
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");

        return answer;
    }
}