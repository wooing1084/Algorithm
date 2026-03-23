import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[] indices = new int[n];
        for(int i = 0; i < n; i++){
            int maxIdx = 0;
            for(int j = 1; j < n; j++){
                if(arr[n - indices[j] - 1][j] > arr[n - indices[maxIdx] - 1][maxIdx])
                    maxIdx = j;
            }

            if(i == n - 1)
                System.out.print(arr[n - indices[maxIdx] - 1][maxIdx]);
                    
            indices[maxIdx]++;            
        }
    }
}