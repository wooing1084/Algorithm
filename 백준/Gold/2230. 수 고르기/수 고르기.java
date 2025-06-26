import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        
        int l = 0;
        int r = 0;
        long answer = Long.MAX_VALUE;
        while(l <= r && r < N){
            long diff = arr[r] - arr[l];
            if(diff >= M){
                answer = Math.min(answer, diff);
                l++;
            }
            else{
                r++;
            }
        }

        System.out.println(answer);
    }
}