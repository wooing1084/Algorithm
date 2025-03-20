import java.io.*;
import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        if(rocks.length == n)
            return distance;

        Arrays.sort(rocks);
        int[] rockArray = new int[rocks.length + 2];
        for(int i = 1; i < rocks.length + 1; i++)
            rockArray[i] = rocks[i - 1];
        rockArray[0] = 0;
        rockArray[rockArray.length - 1] = distance;
        
        int left = 0;
        int right = distance;
        int answer = 0;
        while(left < right){
            int mid = (left + right) / 2;
            int last = 0;
            int remove = 0;
            int min = distance;
            for(int i = 1; i < rockArray.length; i++){
                int dist = rockArray[i] - rockArray[last];
                if(dist <= mid){
                    remove++;
                }
                else{
                    last = i;
                    min = Math.min(min, dist);
                }
                    
            }
            
            if(remove <= n){
                left = mid + 1;
                answer = Math.max(answer, min);
            }
            else{
                right = mid;
            }
        }
        
        return answer;
    }
}