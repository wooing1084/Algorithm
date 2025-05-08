import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> {
            if(a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int answer = 0;
        int pos = Integer.MIN_VALUE;
        for(int i = 0; i < routes.length; i++){
            int s = routes[i][0];
            int e = routes[i][1];
            
            if(s > pos){
                answer++;
                pos = e;
            }
        }
        
        return answer;
    }
}