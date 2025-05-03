import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static String[] alphabet = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        makeList(0, "");
    
        
        return list.indexOf(word);
    }
    
    void makeList(int idx, String str){
        list.add(str);
        if(idx == 5)
            return;
        
        for(String s : alphabet){
            makeList(idx + 1, str + s);
        }
    }
    
    
}