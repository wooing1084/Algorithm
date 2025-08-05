import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] memArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] costArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int costSum = Arrays.stream(costArr).sum();

        int[][] dp = new int[N + 1][costSum + 1];
        int result = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            int mem = memArr[i - 1];
            int cost = costArr[i - 1];
            for(int j = 0; j <= costSum; j++){
                dp[i][j] = dp[i - 1][j];
                
                if(cost <= j)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cost] + mem);
                
                if(dp[i][j] >= M)
                    result = Math.min(result, j);
            }
        }

        System.out.println(result);
    }
}