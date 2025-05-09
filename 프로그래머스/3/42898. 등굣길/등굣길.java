import java.util.*;

class Solution {
    static int[][] map;
    static int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];
        for(int i = 0; i < puddles.length; i++){
            map[puddles[i][1]][puddles[i][0]] = 1;
        }
        
        dp[1][1] = 1;
        for(int y = 1; y <= n; y++){
            for(int x = 1; x <= m; x++){
                if(x == 1 && y == 1)
                    continue;
                if(map[y][x] == 1)
                    continue;
                dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % 1000000007;
            }
        }
        
        return dp[n][m];
    }
}