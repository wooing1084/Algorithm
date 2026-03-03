import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] line = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(line[i]);
        }

        int[] last = new int[n];
        last[0] = arr[0];
        int lastIdx = 1;
        int[] pos = new int[n];
        int[] prev = new int[n];
        for(int i = 1; i < n; i++){
            if(last[lastIdx - 1] < arr[i]){
                pos[lastIdx] = i;
                prev[i] = pos[lastIdx - 1];
                last[lastIdx++] = arr[i];
            }
                
            else {
                int l = 0;
                int r = lastIdx;
                while(l < r){
                    int mid = (l + r) / 2;
                    if(arr[i] > last[mid])
                        l = mid + 1;
                    else
                        r = mid;
                }
                last[l] = arr[i];
                pos[l] = i;
                if(l > 0){
                    prev[i] = pos[l - 1];
                }
                 
            }
            
        }

        int[] ans = new int[lastIdx];
        int cur = pos[lastIdx - 1];
        for(int i = lastIdx - 1; i >= 0; i--){
            ans[i] = arr[cur];
            cur = prev[cur];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lastIdx + "\n");
        for(int i = 0; i < lastIdx; i++)
            sb.append(ans[i] + " ");
        System.out.println(sb.toString());
    }
}