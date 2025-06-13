import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] prefix = new int[n];
        String[] line = br.readLine().split(" ");
        arr[0] = Integer.parseInt(line[0]);
        prefix[0] = arr[0];
        for(int i = 1; i < n; i++){
            arr[i] = Integer.parseInt(line[i]);
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int max = 0;
        for(int i = 1; i < n - 1; i++){
            int sum = (prefix[n - 1] - arr[i] - arr[0]) + (prefix[n - 1] - prefix[i]);
            max = Math.max(max, sum);
            
            sum = prefix[i] - arr[0] + prefix[n - 2] - prefix[i - 1];
            max = Math.max(max, sum);

            sum = prefix[n - 2] - arr[i] + prefix[i - 1];
            max = Math.max(max, sum);
        }

        System.out.println(max);
        
        
    }
}