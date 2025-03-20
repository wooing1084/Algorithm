import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            String[] cloth = clothes[i];
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        for(String k : map.keySet()){
            answer *= (map.get(k) + 1);
        }
        
        return answer - 1;
    }
}