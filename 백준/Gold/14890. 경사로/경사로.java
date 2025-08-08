import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, L;
    static int[][] map;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        L = Integer.parseInt(line[1]);

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[] row = new int[N];
        int[] col = new int[N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                row[j] = map[i][j];
                col[j] = map[j][i];
            }

            solve(row);
            solve(col);
        }


        System.out.println(answer);
    }

    static void solve(int[] arr){
        int i;
        int[] used = new int[N];
        for(i = 0; i < N - 1; i++){
            if(arr[i] == arr[i + 1])
                continue;
            
            int diff = arr[i] - arr[i + 1];
            if(diff * diff > 1)
                return;

            int start;
            int end;
            if(diff < 0) {
                start = i - L + 1;
                end = i;
            }
            else {
                start = i + 1;
                end = i + L;
            }

            if(!canSlope(start, end, arr, used))
                return;
            
            
        }

        answer++;
    }

    static boolean canSlope(int start, int end, int[] arr, int[] used){
        if(start < 0 || start >= N || end < 0 || end >= N)
            return false;
        
        int h = arr[start];
        for(int i = start; i <= end; i++){
            if(i < 0 || i >= N)
                return false;
            if(used[i] == 1)
                return false;
            if(arr[i] != h)
                return false;
        }

        for(int i = start; i <= end; i++){
            used[i] = 1;
        }
        
        return true;
    }
}