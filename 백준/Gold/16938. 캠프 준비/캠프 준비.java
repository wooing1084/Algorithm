import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, L, R, X;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        L = Integer.parseInt(line[1]);
        R = Integer.parseInt(line[2]);
        X = Integer.parseInt(line[3]);

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        brute(-1, 0);
        System.out.println(answer);
        
    }

    static void brute(int idx, int bit){
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            boolean isUsed = (bit & (1 << i)) != 0;
            if(isUsed){
                sum += arr[i];
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
        }

        if(sum >= L && sum <= R && (max - min) >= X){
            answer++;
        }

        for(int i = idx + 1; i < N; i++){
            brute(i, bit | (1 << i));
        }
    }
}