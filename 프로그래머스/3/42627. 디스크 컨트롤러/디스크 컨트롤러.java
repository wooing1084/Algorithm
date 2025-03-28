import java.util.*;

class Job{
    int idx, req, dur;
    Job(int idx, int req, int dur){
        this.idx = idx;
        this.req = req;
        this.dur = dur;
    }
    
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Job> pq2 = new PriorityQueue<>((a, b) -> {
            if(a.dur == b.dur){
                if(a.req == b.req){
                    return a.idx - b.idx;
                }
                return a.req - b.req;
            }
            return a.dur - b.dur;
        });
        
        PriorityQueue<Job> pq1 = new PriorityQueue<>((a,b) -> {
            return a.req - b.req;
        });
        
        for(int i = 0; i < jobs.length; i++){
            Job j = new Job(i, jobs[i][0], jobs[i][1]);
            pq1.add(j);
        }
        
        int time = pq1.peek().req;
        while(!pq1.isEmpty()){
            if(pq1.peek().req > time)
                break;
            pq2.add(pq1.poll());
        }
        
        while(!pq1.isEmpty() || !pq2.isEmpty()){
            if(pq2.isEmpty()) {
                if(time <= pq1.peek().req)
                    time = pq1.peek().req;
            }
                
            while(!pq1.isEmpty()){
                if(pq1.peek().req > time)
                    break;
                pq2.add(pq1.poll());
            }
            
            Job j = pq2.poll();
            time += j.dur;
            answer += (time - j.req);
        }
        
        return answer / jobs.length;
    }
}