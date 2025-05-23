import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        
        long min = Long.MAX_VALUE;
        long[] answer = new long[3];
        for(int i = 0; i < n - 2; i++){
            int l = i;
            int mid = i + 1;
            int r = n - 1;
            while(mid < r){
                long sum = arr[l] + arr[mid] + arr[r];
                if(min > Math.abs(sum)){
                    min = Math.abs(sum);
                    answer[0] = arr[l];
                    answer[1] = arr[mid];
                    answer[2] = arr[r];
                }

                if(sum == 0){
                    System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
                    return;
                }
                else if(sum > 0)
                    r--;
                else
                    mid++;
                
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}