class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        boolean[] losts = new boolean[n];
        boolean[] reserves = new boolean[n];
        int answer = lost.length;
        
        for(int i : lost){
            losts[i-1] = true;
        }
        
        for(int i : reserve){
            reserves[i-1] = true;
        }
        for(int i = 0; i < n; i++){
            if(losts[i] == true && reserves[i]){
                losts[i] = false;
                reserves[i] = false;
            }
                
        }
        for(int i = 0; i < n; i++){
            if(losts[i] && reserves[i] == false){
                if(i == 0){
                    if(reserves[1]){
                        answer--;
                        reserves[1] = false;
                        losts[i] = false;
                    }
                } else if(i == n-1){
                    if(reserves[i-1] && losts[i-1] == false){
                        answer--;
                        reserves[i-1] = false;
                        losts[i] = false;
                    }
                } else{
                    if(reserves[i-1] && losts[i-1] == false){
                        answer--;
                        reserves[i-1] = false;
                        losts[i] = false;
                    } else if(reserves[i+1]){
                        answer--;
                        reserves[i+1] = false;
                        losts[i] = false;
                    }
                }
                
            }
        }
        
        answer = 0;
        for(int i = 0; i < n; i++){
            if(losts[i] == true && reserves[i] == false)
                answer++;
        }
        return n - answer;
    }
}