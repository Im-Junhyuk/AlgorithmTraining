import java.io.*;
import java.util.*;

class Solution {
    
    int lenM;
    int lenS;    
        
    int curM;
    int curS;
    
    int opSM;
    int opSS;
    
    int opEM;
    int opES;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        String[] len = video_len.split(":");
        lenM = Integer.valueOf(len[0]);
        lenS = Integer.valueOf(len[1]);
        
        String[] posArr = pos.split(":");
        curM = Integer.valueOf(posArr[0]);
        curS = Integer.valueOf(posArr[1]);
        
        String[] opS = op_start.split(":");
        opSM = Integer.valueOf(opS[0]);
        opSS = Integer.valueOf(opS[1]);
        
        String[] opE = op_end.split(":");
        opEM = Integer.valueOf(opE[0]);
        opES = Integer.valueOf(opE[1]);
        
        if(isInOpening())
            goOpEnd();
        
        for(int i = 0; i < commands.length; i++){
            switch (commands[i]){
                case "prev":
                    op_prev();
                    break;
                case "next":
                    op_next();
            }
        }
        
        String answer = String.format("%02d:%02d", curM, curS);
        return answer;
    }
    
    void op_prev(){
        
        curS -= 10;
        if(curS < 0){
            if(curM >= 1){
                curM--;
                curS += 60;
            } else {
                curM = 0;
                curS = 0;
            } 
                
        }
        if(isInOpening())
            goOpEnd();
    }
    
    void op_next(){
        
        curS += 10;
        if(curS >= 60){
            curM++;
            curS -= 60;
        }
        
        if(curM > lenM){
            curM = lenM;
            curS = lenS;
        }
        
        if(curM >= lenM && curS >= lenS){
            curM = lenM;
            curS = lenS;
        }
        if(isInOpening())
            goOpEnd();
    }
    
    boolean isInOpening(){

        if(opSM > curM)
            return false;
        if(opSM == curM && opSS > curS)
            return false;
        if(opEM < curM)
            return false;
        if(opEM == curM && opES < curS)
            return false;
        return true;
    }
    
    void goOpEnd(){

        curM = opEM;
        curS = opES;
    }
}