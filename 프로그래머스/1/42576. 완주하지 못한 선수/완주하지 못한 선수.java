import java.util.HashMap;

class Solution {
    
    public static HashMap<String, Integer> map = new HashMap<>();
    
    public String solution(String[] participant, String[] completion) {
        
        for(int i = 0; i < participant.length; i++){
            String name = participant[i];
            
            if(map.containsKey(name)){
                map.put(name, map.get(name) + 1);
            }
            else {
                map.put(name, 1);
            }
        }
        
        for(int i = 0; i < completion.length; i++){
            String name = completion[i];
            
            int n = map.get(name) - 1;
            if(n <= 0){
                map.remove(name);
            }
            else{
                map.put(name, n);
            }
        }
        
        
        String answer = map.keySet().toArray()[0].toString();
        return answer;
    }
}