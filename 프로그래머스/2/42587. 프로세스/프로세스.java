import java.util.*;

class Task{
    int priority, idx;
    Task(int priority, int idx){
        this.priority = priority;
        this.idx = idx;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            return b.priority - a.priority;
        });
        
        Queue<Task> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            q.add(new Task(priorities[i], i));
            pq.add(new Task(priorities[i], i));
        }
        
        int answer = 1;
        while(!q.isEmpty()){
            Task t = q.poll();
            if(t.priority != pq.peek().priority){
                q.add(t);
                continue;
            }
            if(t.idx == location)
                break;
            answer++;
            pq.poll();
        }
    
        return answer;
    }
}