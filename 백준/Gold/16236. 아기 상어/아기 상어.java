import java.util.*;
import java.lang.*;
import java.io.*;

class Position{
    int x, y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Main {
    static int N;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Position shark;
    static int time = 0;
    static int size = 2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(line[j]);

                if(map[i][j] == 9){
                    shark = new Position(j, i);
                }
            }
        }
        
        int eatCnt = 0;
        while(true){
            Position fish = bfs();
            if(fish == null)
                break;
            
            map[shark.y][shark.x] = 0;
            shark = fish;
            map[shark.y][shark.x] = 9;
            eatCnt++;
            if(eatCnt >= size){
                size++;
                eatCnt = 0;
            }
        }

        System.out.println(time);
    }

    static Position bfs(){
        PriorityQueue<Position> pq = new PriorityQueue<>((a, b) -> {
            if(a.y == b.y)
                return a.x - b.x;
            return a.y - b.y;
        });

        Queue<Position> queue = new LinkedList<>();
        queue.add(shark);
        int[][] visited = new int[N + 1][N + 1];
        visited[shark.y][shark.x] = 1;

        int iterCnt = 1;
        int timeCnt = 0;
        while(!queue.isEmpty()){
            Position p = queue.poll();
            for(int i = 0; i < 4; i++){
                Position np = new Position(p.x + dx[i], p.y + dy[i]);
                if(np.x < 0 || np.y < 0 || np.x >= N || np.y >= N)
                    continue;
                if(visited[np.y][np.x] == 1)
                    continue;
                if(map[np.y][np.x] > size)
                    continue;
                if(map[np.y][np.x] < size && map[np.y][np.x] != 0)
                    pq.add(np);
                
                queue.add(np);
                visited[np.y][np.x] = 1;
            }

            iterCnt--;
            if(iterCnt <= 0){
                timeCnt++;
                iterCnt = queue.size();

                if(!pq.isEmpty())
                    break;
            }
        }

        if(pq.peek() != null)
            time += timeCnt;

        return pq.poll();
    }
}