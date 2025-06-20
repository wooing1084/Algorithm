import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] prefix = new int[arr.length+1];
        for(int i = 1; i <= N; i++){
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        long answer = 0;
        for(int i = 1; i <= N; i++){
            answer += arr[i - 1] * (prefix[N] - prefix[i]);
        }

        System.out.println(answer);
    }
}