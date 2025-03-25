import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] cnt = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(i % 5 + 1 == answers[i])
                cnt[0]++;
            if(p2[i % p2.length] == answers[i])
                cnt[1]++;
            if(p3[i % p3.length] == answers[i])
                cnt[2]++;
        }
        
        int maxCnt = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i ++){
            if(maxCnt == cnt[i])
                list.add(i + 1);
        }
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}