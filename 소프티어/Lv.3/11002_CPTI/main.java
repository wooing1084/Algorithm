import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[] personalities;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        personalities = new int[N];

        for(int i = 0; i < N; i++){
            personalities[i] = Integer.parseInt(br.readLine(), 2);
        }

        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j< N; j++){

                int cnt = Integer.bitCount(personalities[i] ^ personalities[j]);

                if(cnt <= 2)
                    answer++;
            }
        }

        System.out.println(answer);
        
    }
}
