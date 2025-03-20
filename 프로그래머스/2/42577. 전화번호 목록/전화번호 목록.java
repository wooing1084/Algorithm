import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        Set<String> set = new HashSet<>();
        for(int i = 0; i < phone_book.length; i++){
            String s = phone_book[i];
            for(int j = 1; j <= s.length(); j++){
                String c = s.substring(0, j);
                if(set.contains(c))
                    answer = false;
            }
            set.add(s);
        }
        return answer;
    }
}