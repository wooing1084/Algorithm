import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.stream(truck_weights).boxed().collect(Collectors.toList()));
        
        int answer = 0;
        int nWeight = 0;
        Queue<Integer> tQueue = new LinkedList<>();
        Queue<Integer> wQueue = new LinkedList<>();
        while(!queue.isEmpty() || !tQueue.isEmpty()){
            answer++;
            // 맨 앞 차량의 목표 시간에 도달하면 poll
            // 다음 차량의 무게가 감당 가능하면 add
                // queue.add(현재시간 + 다리 길이)
           if(!tQueue.isEmpty() && tQueue.peek() == answer){
               tQueue.poll();
               nWeight -= wQueue.poll();
           }
            if(!queue.isEmpty() && weight >= (nWeight + queue.peek())){
                int w = queue.poll();
                nWeight += w;
                wQueue.add(w);
                tQueue.add(answer + bridge_length);
            }
        }
        
        return answer;
    }
}