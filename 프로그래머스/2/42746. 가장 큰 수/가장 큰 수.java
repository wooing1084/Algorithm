import java.util.*;


class Solution {
    public String solution(int[] numbers) {
        String[] arr = Arrays.stream(numbers)
            .boxed()
            .map(Object::toString)
            .toArray(String[]::new);
        Arrays.sort(arr, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        
        StringBuilder answer = new StringBuilder();
        for(String s : arr)
            answer.append(s);
        
        if(answer.toString().charAt(0) == '0')
            return "0";
        
        return answer.toString();
    }
}