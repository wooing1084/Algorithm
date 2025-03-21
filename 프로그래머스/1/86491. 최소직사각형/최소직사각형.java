import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int[] flatten = Arrays.stream(sizes).flatMapToInt(Arrays::stream).toArray();
        Arrays.sort(flatten);
        for(int i = 0; i < flatten.length; i++){
            for(int j = i; j < flatten.length; j++){
                int k = 0;
                for(k = 0; k < sizes.length; k++){
                    if(flatten[i] >= sizes[k][0] && flatten[j] >= sizes[k][1])
                        continue;
                    if(flatten[j] >= sizes[k][0] && flatten[i] >= sizes[k][1])
                        continue;
                        
                    break;
                }
                if(k == sizes.length)
                    return flatten[i] * flatten[j];
            }
        }
        
        return -1;
    }
}