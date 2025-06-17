import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = 0;
        int r = 0;
        long sum = 0;
        int answer = Integer.MAX_VALUE;
        while(r < N){
            while(sum < S && r < N){
                sum += arr[r];
                r++;
            }
            while(sum >= S && l <= r){
                answer = Math.min(answer, r - l);
                sum -= arr[l];
                l++;
            }
        }

        if(answer == Integer.MAX_VALUE)
            answer = 0;

        System.out.println(answer);
        
    }
}