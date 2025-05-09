import java.util.*;

class Solution {
    static int[][] dp;
    public int solution(int[][] triangle) {
        dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i = 0; i < triangle.length - 1; i++){
            for(int j = 0; j <= i; j++){
                for(int k = 0; k < 2; k++){
                    dp[i + 1][j + k] = Math.max(dp[i][j] + triangle[i + 1][j + k], dp[i + 1][j + k]);
                }
            }
        }
        
        return Arrays.stream(dp[triangle.length - 1]).max().getAsInt();
    }
}