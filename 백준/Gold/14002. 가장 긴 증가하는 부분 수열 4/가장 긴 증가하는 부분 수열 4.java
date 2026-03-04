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
        int[] prev = new int[n];
        int[] pos = new int[n];
        last[0] = arr[0];
        int lastIdx = 1;
        for(int i = 1; i < n; i++){
            int l = 0;
            int r = lastIdx;
            while(l < r){
                int mid = (l + r) / 2;
                if(last[mid] >= arr[i]) r = mid;
                else l = mid + 1;
            }

            pos[l] = i;
            last[l] = arr[i];
            if(l > 0)
                prev[i] = pos[l - 1];
            if (l == lastIdx){
                lastIdx++;
            }
        }

        int[] ans = new int[lastIdx];
        int now = pos[lastIdx - 1];
        for(int i = lastIdx - 1; i >= 0; i--){
            ans[i] = arr[now];
            now = prev[now];
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(lastIdx+ "\n");
        for(int i = 0; i < lastIdx; i++){
            sb.append(ans[i]+" ");
        }

        System.out.println(sb.toString());

        
    }
}