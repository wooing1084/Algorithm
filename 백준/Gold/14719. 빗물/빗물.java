import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int H, W;
    static int[] arr;
    static int[] waterHeight;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        H = Integer.parseInt(line[0]);
        W = Integer.parseInt(line[1]);
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        waterHeight = new int[W];

        for(int i = 0; i < W - 1; i++){
            int h = arr[i];
            int maxIdx = i + 1;
            for(int j = i + 1; j < W; j++){
                if(arr[maxIdx] <= arr[j])
                    maxIdx = j;
            }

            fill(waterHeight, i, maxIdx);
        }
        
        int answer = 0;
        for(int i = 0; i < W; i++){
            int h = waterHeight[i] - arr[i];
            if(h > 0)
                answer += h;
        }

        System.out.println(answer);
        
        
    }

    static void fill(int[] water, int lIdx, int rIdx){
        int h = Math.min(arr[lIdx], arr[rIdx]);
        for(int i = lIdx; i <= rIdx; i++){
            waterHeight[i] = Math.max(waterHeight[i], h);
        }
    }
}