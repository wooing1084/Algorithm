import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        
        int l = 0;
        int r = arr.length - 1;
        int[] answer = new int[2];
        long minDiff = Long.MAX_VALUE;
        while(l < r){
            long sum = arr[l] + arr[r];
            long absSum = Math.abs(sum);
            if(sum == 0){
                answer[0] = arr[l];
                answer[1] = arr[r];
                break;
            }
            if(absSum < minDiff){
                minDiff = absSum;
                answer[0] = arr[l];
                answer[1] = arr[r];
            }

            if(sum < 0){
                l++;
            }
            else if(sum > 0){
                r--;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
        
    }
}