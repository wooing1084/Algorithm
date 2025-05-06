import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int answer = 0;
        int idx = 0;
        boolean[] visited = new boolean[people.length];
        for(int i = people.length - 1; i >= 0; i--){
            if(visited[i])
                continue;
            if(people[i] + people[idx] <= limit){
                visited[idx] = true;
                idx++;
            }
            answer++;    
            visited[i] = true;
        }
        
        return answer;
    }
}