class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int startTime = 0;
        
        for(int i = 0; i < attacks.length; i++){
            int recoveryTime = attacks[i][0] - startTime - 1;
            answer += recoveryTime * bandage[1] + recoveryTime / bandage[0] * bandage[2];
            if(answer > health){
                answer = health;
            }
            
            answer -= attacks[i][1];
            if(answer <= 0){
                return -1;
            }
            
            startTime = attacks[i][0];
        }
        
        return answer;
    }
}