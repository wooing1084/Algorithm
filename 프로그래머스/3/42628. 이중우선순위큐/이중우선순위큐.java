import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < operations.length; i++){
            String[] operation = operations[i].split(" ");
            if(operation[0].equals("I")){
                int n = Integer.parseInt(operation[1]);
                list.add(n);
            }
            else{
                if(list.size() == 0)
                    continue;
                PriorityQueue<Integer> queue;
                if(operation[1].equals("-1"))
                    queue = new PriorityQueue<>();
                else 
                    queue = new PriorityQueue<>(Collections.reverseOrder());
                
                queue.addAll(list);
                list.remove(queue.poll());
            }
        }
        
        int[] answer = new int[2];
        if(list.size() == 0){
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[0] = list.stream().max(Integer::compare).get();
            answer[1] = list.stream().min(Integer::compare).get();
        }
        
        
        
        
        return answer;
    }
}