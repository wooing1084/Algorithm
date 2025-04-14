import java.util.*;

class Solution {
    static int answer = 0;
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++){
            while(!stack.isEmpty() && stack.peek() < number.charAt(i) && k > 0){
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        if(k > 0)
            return sb.reverse().toString().substring(0, sb.length() - k);
        
        return sb.reverse().toString();
    }
}