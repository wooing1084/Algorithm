import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long min = 0;
        long max = times[times.length - 1] * (long)n;
        long answer = 0;
        while(min <= max){
            long mid = (max + min) / 2;
            long temp = 0;
            for(int i = 0; i < times.length; i++){
                temp += mid/times[i];
            }
            
            if(temp < n)
                min = mid + 1;
            else {
                max = mid - 1;
                answer = mid;
            }
                
        }
        
        return answer;
    }
}