import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] rocks = new int[N + 1];
        Map<Integer, Integer> dp = new HashMap<>();
        String[] line = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            rocks[i] = Integer.parseInt(line[i]);
            dp.put(rocks[i], 0);
        }

        Set<Integer> keySet = dp.keySet();
        for(int i = 0; i < N; i++){
            int max = 0;
            for(Integer k : keySet){
                if(k > rocks[i])
                    continue;
                int v = dp.get(k);
                if(v > max)
                    max = v;
            }

            dp.replace(rocks[i], max + 1);
        }

        System.out.println(dp.values().stream().max(Comparator.naturalOrder()).orElse(0));
    }
}
