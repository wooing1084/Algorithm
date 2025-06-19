import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        
        int[] W = new int[N + 1];
        int[] V = new int[N + 1];
        for(int i = 1; i <= N; i++){
            line = br.readLine().split(" ");
            W[i] = Integer.parseInt(line[0]);
            V[i] = Integer.parseInt(line[1]);
        }

        int[][] dp = new int[N + 1][K + 1];
        for(int i = 1; i<= N; i++){
            for(int j = 1; j <= K; j++){
                if(W[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
            }
        }

        System.out.println(dp[N][K]);
    }   
}