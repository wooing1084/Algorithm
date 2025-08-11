import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int[] last = new int[n];
        last[0] = arr[0];
        int lastIdx = 1;
        for(int i = 1; i < n; i++){
            if(last[lastIdx - 1] < arr[i]){
                last[lastIdx++] = arr[i];
            }
            else {
                int l = 0;
                int r = lastIdx;
                while(l < r){
                    int mid = (l + r) / 2;
                    if(last[mid] < arr[i])
                        l = mid + 1;
                    else
                        r = mid;
                }
                last[l] = arr[i];
            }
        }
        
        System.out.println(lastIdx);
    }
}