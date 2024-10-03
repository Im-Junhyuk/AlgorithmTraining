import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Job> exeQ = new PriorityQueue<>(
            (j1, j2) -> j1.exeTime - j2.exeTime);
        PriorityQueue<Job> reqQ = new PriorityQueue<>(
            (j1, j2) -> {if(j1.reqTime != j2.reqTime)
                            return j1.reqTime - j2.reqTime;
                        else
                            return j1.exeTime - j2.exeTime;
                        });
        
        for(int i = 0; i < jobs.length; i++){
            reqQ.add(new Job(jobs[i][0], jobs[i][1]));
        }
        
        int curTime = 0;
        while(!reqQ.isEmpty() || !exeQ.isEmpty()){
            while(!reqQ.isEmpty() && reqQ.peek().reqTime <= curTime){
                exeQ.add(reqQ.poll());
            }
            
            if(exeQ.isEmpty()){
                exeQ.add(reqQ.poll());
                curTime = exeQ.peek().reqTime;
            }
            
            Job curJob = exeQ.poll();
            
            curTime += curJob.exeTime;
            answer += curTime - curJob.reqTime;
        }
        return answer / jobs.length;
    }
    
    class Job{
        int exeTime;
        int reqTime;
        Job(int reqTime, int exeTime){
            this.reqTime = reqTime;
            this.exeTime = exeTime;
        }
    }
}