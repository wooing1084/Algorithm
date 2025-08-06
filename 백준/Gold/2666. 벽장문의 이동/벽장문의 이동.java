import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int n, m;
    static int[] openList;
    static int[] indices;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        openList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        m = Integer.parseInt(br.readLine());
        indices = new int[m];
        for(int i = 0; i < m; i++){
            indices[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(0, openList[0], openList[1]));
    }

    static int solve(int idx, int a, int b){
        if(idx >= indices.length){
            return 0;
        }

        int now = indices[idx];
        int n1 = Math.abs(now - a);
        int n2 = Math.abs(now - b);

        return Math.min(n1 + solve(idx + 1, now, b), n2 + solve(idx + 1, a, now));
    }
}