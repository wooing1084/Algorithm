import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[] map = new int[101];
        boolean[] visited = new boolean[101];

        Map<Integer, Integer> ladders = new HashMap<>();
        for(int i = 0; i < N; i++){
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            map[x] = 1;
            ladders.put(x, y);
        }

        Map<Integer, Integer> snakes = new HashMap<>();
        for(int i = 0; i < M; i++){
            line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            map[u] = 2;
            snakes.put(u, v);
        }

        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(1);
        visited[1] = true;
        int answer = 0;
        while(!bfs.isEmpty()){
            int size = bfs.size();
            while(size > 0){
                int pos = bfs.poll();

                if(pos == 100)
                    break;

                size--;

                for(int i = 1; i <= 6; i++){
                    int nextPos = pos + i;

                    if(nextPos > 100)
                        continue;

                    while(map[nextPos] != 0){
                        if(map[nextPos] == 1){
                            visited[nextPos] = true;
                            nextPos = ladders.get(nextPos);
                        }
                        else if(map[nextPos] == 2){
                            visited[nextPos] = true;
                            nextPos = snakes.get(nextPos);
                        }
                    }

                    if(visited[nextPos])
                        continue;
                    visited[nextPos] = true;
                    bfs.add(nextPos);
                }
            }

            if(size != 0)
                break;
            answer++;
        }

        System.out.println(answer);
        
    }
}