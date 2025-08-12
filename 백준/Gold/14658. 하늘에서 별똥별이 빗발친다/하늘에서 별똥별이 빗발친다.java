import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int L = Integer.parseInt(line[2]);
        int K = Integer.parseInt(line[3]);

        int[][] stars = new int[K][2];
        for(int i = 0; i < K; i++){
            line = br.readLine().split(" ");
            stars[i][0] = Integer.parseInt(line[0]);
            stars[i][1] = Integer.parseInt(line[1]);
        }

        int answer = 0;
        for(int[] s1 : stars){
            for(int[] s2 : stars){
                int cnt = 0;
                for(int[] s: stars){
                    if(s[0] >= s1[0] && s[0] <= s1[0] + L &&
                      s[1] >= s2[1] && s[1] <= s2[1] + L)
                        cnt++;
                }

                answer = Math.max(answer, cnt);
            }
        }

        System.out.println(K - answer);
    }
}