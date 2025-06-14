import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] arr = new int[N];
        line = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(line[i]);
        }

        int[] prefix = new int[N + 1];
        for(int i = 1; i <= N; i++){
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            sb.append(prefix[e] - prefix[s - 1] + "\n");
        }

        System.out.println(sb.toString());
    }
}