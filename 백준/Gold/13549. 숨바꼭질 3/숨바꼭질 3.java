import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Map<Integer, Integer> distances = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        Queue<Integer> bfs = new LinkedList<>();
        distances.put(K, 0);
        addQueue(bfs, K);
        
        while(!bfs.isEmpty()){
            int size = bfs.size();
            while(size > 0){
                int n = bfs.poll();
                
                if(n == N)
                    break;
                
                addQueue(bfs, n);
                size--;
            }

            if(size > 0)
                break;
        }

        System.out.println(distances.get(N));
        
    }

    static void addQueue(Queue<Integer> queue, int n){
        int now_distance = distances.get(n);
        if(n <= 100000){
            int dis = distances.getOrDefault(n + 1, Integer.MAX_VALUE);
            if(dis == Integer.MAX_VALUE)
                queue.add(n + 1);
            distances.put(n + 1, Math.min(dis, now_distance + 1));
        }
        if(n >= 0){
            int dis = distances.getOrDefault(n - 1, Integer.MAX_VALUE);
            if(dis == Integer.MAX_VALUE)
                queue.add(n - 1);
            distances.put(n - 1, Math.min(dis, now_distance + 1));
        }
        if(n % 2 == 0 && (n / 2) >= 0){
            int dis = distances.getOrDefault(n / 2, Integer.MAX_VALUE);
            if(dis == Integer.MAX_VALUE)
                queue.add(n / 2);
            distances.put(n / 2, Math.min(dis, now_distance));
        }
    }
}