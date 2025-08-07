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
    static int N, M;
    static List<Position> wallList = new ArrayList<>();
    static List<Position> virusPos = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        for(int i = 0; i < N; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                int n = Integer.parseInt(line[j]);
                if(n == 1){
                    wallList.add(new Position(j, i));
                }
                else if(n == 2){
                    virusPos.add(new Position(j, i));
                }
            }
        }

        solve(0, -1, new Position[M]);

        if(answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    static void solve(int cnt, int idx, Position[] virus){
        if(cnt == M){
            int[][] map = new int[N][N];
            for(Position wall : wallList)
                map[wall.y][wall.x] = 1;
            Queue<Position> queue = new LinkedList<>();
            for(int i = 0; i < M; i++){
                map[virus[i].y][virus[i].x] = 1;
                queue.add(virus[i]);
            }
                
            bfs(map, queue);

            return;
        }

        for(int i = idx + 1; i < virusPos.size(); i++){
            virus[cnt] = virusPos.get(i);
            solve(cnt + 1, i, virus);
        }
    }

    static void bfs(int[][] visited, Queue<Position> queue){
        int size = queue.size();
        int num = 0;
        int sum = wallList.size() + M;
        while(!queue.isEmpty()){
            Position pos = queue.poll();
            for(int i = 0; i < 4; i++){
                Position newPos = new Position(pos.x + dx[i], pos.y + dy[i]);
                if(newPos.x < 0 || newPos.x >= N || newPos.y < 0 || newPos.y >= N)
                    continue;
                if(visited[newPos.y][newPos.x] != 0)
                    continue;

                visited[newPos.y][newPos.x] = 1;
                queue.add(newPos);
            }

            size--;
            if(size <= 0){
                size = queue.size();
                sum += size;
                
                if(size > 0)
                    num++;
            }
        }

        if(sum == N * N)
            answer = Math.min(answer, num);
    }
}