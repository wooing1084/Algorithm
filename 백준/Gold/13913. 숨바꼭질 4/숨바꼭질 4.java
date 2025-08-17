import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Map<Integer, Integer> distances = new HashMap<>();
    static Map<Integer, Integer> paths = new HashMap<>();
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
        int n = N;
        while(n != K){
            System.out.print(n + " ");
            int p = paths.get(n);
            n = p;
        }

        System.out.print(n);
        
        
    }

    static void addQueue(Queue<Integer> queue, int n){
        int now_distance = distances.get(n);
        if(n <= 100000){
            int dis = distances.getOrDefault(n + 1, Integer.MAX_VALUE);
            if(dis > now_distance + 1){
                queue.add(n + 1);
                distances.put(n + 1, now_distance + 1);
                paths.put(n + 1, n);
            }
        }
        if(n >= 0){
            int dis = distances.getOrDefault(n - 1, Integer.MAX_VALUE);
            if(dis > now_distance + 1){
                queue.add(n - 1);
                distances.put(n - 1, now_distance + 1);
                paths.put(n - 1, n);
            }
        }
        if(n % 2 == 0 && (n / 2) >= 0){
            int dis = distances.getOrDefault(n / 2, Integer.MAX_VALUE);
            if(dis > now_distance + 1){
                queue.add(n / 2);
                distances.put(n / 2, now_distance + 1);
                paths.put(n / 2, n);
            }
        }
    }
}