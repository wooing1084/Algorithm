import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = Integer.MAX_VALUE;
        int len = name.length();
        for(int i = 0; i < len; i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int idx = i + 1;
            while(idx < len && name.charAt(idx) == 'A'){
                idx++;
            }
            
            move = Math.min(move, i * 2 + len - idx);
            move = Math.min(move, (len - idx) * 2 + i);
        }
    
        return answer + move;
    }
    
}