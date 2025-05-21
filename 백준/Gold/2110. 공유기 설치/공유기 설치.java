import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int r = Integer.MIN_VALUE;
        int l = 0;
        int[] houses = new int[n];
        for(int i = 0; i < n; i++){
            houses[i] = Integer.parseInt(br.readLine());
            r = Math.max(r, houses[i]);
        }

        Arrays.sort(houses);

        while(l <= r){
            int mid = (l + r) / 2;
            int lastPos = houses[0];
            int cnt = 1;
            for(int i = 1; i < n; i++){
                if(houses[i] - lastPos >= mid){
                    cnt++;
                    lastPos = houses[i];
                }
            }

            if(cnt >= m)
                l = mid + 1;
            else
                r = mid - 1;
        }

        System.out.println(r);
        
    }
}