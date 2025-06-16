import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i ++){
            line = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] prefix = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                prefix[i][j] = prefix[i][j - 1] + map[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            line = br.readLine().split(" ");
            int y1 = Integer.parseInt(line[0]);
            int x1 = Integer.parseInt(line[1]);
            int y2 = Integer.parseInt(line[2]);
            int x2 = Integer.parseInt(line[3]);
            int sum = 0;
            for(int y = y1; y <= y2; y++){
                sum += prefix[y][x2] - prefix[y][x1 - 1];
            }

            sb.append(sum + "\n");
        }

        System.out.println(sb.toString());       
    }
}