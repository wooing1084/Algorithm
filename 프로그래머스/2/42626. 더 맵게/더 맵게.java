import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        while(pq.peek() < K){
            Integer a = pq.poll();
            Integer b = pq.poll();
            if(b == null)
                return -1;
            pq.add(a + b * 2);
            answer++;
        }
        return answer;
    }
}