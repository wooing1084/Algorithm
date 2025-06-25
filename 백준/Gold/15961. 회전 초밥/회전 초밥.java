import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int D = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);
        int C = Integer.parseInt(line[3]);

        int[] sushiRail = new int[N];
        for(int i = 0; i < N; i++){
            int sushi = Integer.parseInt(br.readLine());
            sushiRail[i] = sushi;
        }

        int[] sushiCnt = new int[D + 1];
        Set<Integer> sushiTypes = new HashSet<>();
        sushiCnt[C]++;
        sushiTypes.add(C);
        for(int i = 0; i < K; i++){
            sushiCnt[sushiRail[i]]++;
            sushiTypes.add(sushiRail[i]);
        }

        int answer = sushiTypes.size();
        if(N == K){
            System.out.println(answer);
            return;
        }

        for(int i = 1; i < N; i++){
            int j = (i + K - 1) % N;
            sushiCnt[sushiRail[i - 1]]--;
            if(sushiCnt[sushiRail[i - 1]] <= 0)
                sushiTypes.remove(sushiRail[i - 1]);
            sushiCnt[sushiRail[j]]++;
            if(sushiCnt[sushiRail[j]] >= 1)
                sushiTypes.add(sushiRail[j]);
            
            answer = Math.max(answer, sushiTypes.size());
        }
            
        System.out.println(answer);
    }
}