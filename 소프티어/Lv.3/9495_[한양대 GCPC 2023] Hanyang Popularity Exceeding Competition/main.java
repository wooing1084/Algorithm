import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] P;
    static int[] C;
    static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];
        C = new int[N];
        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            P[i] = Integer.parseInt(line[0]);   
            C[i] = Integer.parseInt(line[1]);
        }

        for(int i = 0; i < N; i++){
            if(Math.abs(P[i] - answer) <= C[i])
                answer++;
        }

        System.out.println(answer);
    }
}
