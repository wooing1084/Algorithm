import java.util.*;

class Solution {
    public int solution(String arr[]) {   
        int len = arr.length / 2 + 1;
        int[][] maxDP = new int[len][len];
        int[][] minDP = new int[len][len];
        
        for(int i = 0; i < len; i++){
            maxDP[i][i] = Integer.parseInt(arr[i * 2]);
            minDP[i][i] = Integer.parseInt(arr[i * 2]);
        }
        
        for(int step = 1; step < len; step++){
            for(int i = 0; i < len - step; i++){
                int j = i + step;
                maxDP[i][j] = Integer.MIN_VALUE;
                minDP[i][j] = Integer.MAX_VALUE;
                
                for(int k = i; k < j; k++){
                    String op = arr[k * 2 + 1];
                    
                    if(op.equals("+")){
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k + 1][j]);
                    }
                    else {
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - maxDP[k + 1][j]);
                    }
                }
            }
        }
        
        return maxDP[0][len - 1];
    }
}