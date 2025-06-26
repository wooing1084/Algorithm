import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int N, R, C, answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        R = Integer.parseInt(line[1]);
        C = Integer.parseInt(line[2]);

        solve(0, 0, (int)Math.pow(2, N));
    }

    static void solve(int r, int c, int size){
        if(size == 1){
            System.out.println(answer);
            return;
        }

        int nSize = size / 2;
        if(R < r + nSize && C < c + nSize){
            solve(r, c, nSize);
        }
        else if(R < r + nSize && C >= c + nSize){
            answer += (size * size) / 4;
            solve(r, c + nSize, nSize);
        }
        else if(R >= r + nSize && C < c + nSize){
            answer += (size * size) / 4 * 2;
            solve(r + nSize, c, nSize);
        }
        else{
            answer += (size * size) / 4 * 3;
            solve(r + nSize, c + nSize, nSize);
        }
    }
}