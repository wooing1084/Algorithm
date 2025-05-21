import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");
        int r = Integer.MIN_VALUE;
        int l = 0;
        int[] trees = new int[n];
        for(int i = 0; i < n; i++){
            trees[i] = Integer.parseInt(line[i]);
            r = Math.max(r, trees[i]);
        }

        while(l <= r){
            int mid = (l + r) / 2;
            long sum = 0;
            for(int i = 0; i < n; i++){
                if(trees[i] > mid)
                    sum += trees[i] - mid;
            }

            if(sum >= m)
                l = mid + 1;
            else
                r = mid - 1;
        }

        System.out.println(r);
        
    }
}