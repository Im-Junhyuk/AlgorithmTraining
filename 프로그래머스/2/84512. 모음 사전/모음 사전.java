class Solution {
    
    int cnt;
    
    char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    
    char[] answer;
    char[] temp;
    
    boolean isEnd;
    
    public int solution(String word) {
        
        answer = new char[word.length()];
        temp = new char[5];
        
        for(int i = 0; i < word.length(); i++){
            answer[i] = word.charAt(i);
        }
        
        cnt = 0;
        isEnd = false;
        permutation(0);
        
        return cnt;
    }
    
    void permutation(int depth){
        if(depth == answer.length){
            isEqual();
        }
        if(depth == 5)
            return;
        if(isEnd){
            return;
        }
        
        for(int i = 0; i < 5; i++){
            if(isEnd == false){
                temp[depth] = alphabet[i];
                cnt++;
                permutation(depth+1);
            }
        }
    }
    
    boolean isEqual(){
        for(int i = 0; i < answer.length; i++){
            if(answer[i] != temp[i])
                return false;
        }
        isEnd = true;
        return true;
    }
}