import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            int l = i + 1;
            int r = n - 1;
            while(l <= r){
                int mid = (l + r) / 2;
                int sum = arr[mid] + arr[i];
                int abs_sum = Math.abs(arr[mid] + arr[i]);
                if(abs_sum < min){
                    min = abs_sum;
                    answer[0] = arr[i];
                    answer[1] = arr[mid];
                }

                if(sum < 0)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
        
    }
}