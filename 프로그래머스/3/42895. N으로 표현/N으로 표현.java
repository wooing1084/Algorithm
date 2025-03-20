import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        int answer = -1;
        List<Set<Integer>> list = new ArrayList<>();
        list.add(new HashSet<Integer>());
        
        int digit = 0;
        for(int i = 1; i <= 8; i++){
            Set<Integer> newSet = new HashSet<Integer>();
            digit = digit * 10 + N;
            newSet.add(digit);
            
            for(int j = 1; j < i; j++){
                int k = i - j;
                for(Integer n1 : list.get(j)){
                    for(Integer n2 : list.get(k)){
                        newSet.add(n1 + n2);
                        newSet.add(n1 * n2);
                        newSet.add(n1 - n2);
                        newSet.add(n2 - n1);
                        if(n1 != 0)
                            newSet.add(n2 / n1);
                        if(n2 != 0)
                            newSet.add(n1 / n2);
                    }
                }
            }
            
            if(newSet.contains(number)){
                answer = i;
                break;
            }
            list.add(newSet);
        }
        
        return answer;
    }
}