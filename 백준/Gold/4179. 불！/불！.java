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
    static int R, C;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Position start;
    static Queue<Position> fireQueue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
    
            map = new int[R][C]; // 0 : 이동 가능, 1 : 벽, 2 : 불
        for(int i = 0; i < R; i++){
            line = br.readLine().split("");
            for(int j = 0; j < C; j++){
                if(line[j].equals("#"))
                    map[i][j] = 1;
                else if(line[j].equals("J"))
                    start = new Position(j, i);
                else if(line[j].equals("F")){
                    map[i][j] = 2;
                    fireQueue.add(new Position(j, i));
                }
            }
        }

        boolean[][] visited = new boolean[R][C];
        Queue<Position> bfs = new LinkedList<>();
        bfs.add(start);
        visited[start.y][start.x] = true;
        int answer = 0;
        boolean isFind = false;
        while(!bfs.isEmpty()){
            answer++;
            int size = fireQueue.size();
            while(size > 0){
                Position fPos = fireQueue.poll();
                for(int i = 0; i < 4; i++){
                    Position next = new Position(fPos.x + dx[i], fPos.y + dy[i]);
                    if(next.x < 0 || next.x >= C || next.y < 0 || next.y >= R)
                        continue;
                    if(map[next.y][next.x] != 0)
                        continue;

                    map[next.y][next.x] = 2;
                    fireQueue.add(next);
                }
                size--;
            }


            size = bfs.size();
            while(size > 0){
                Position pos = bfs.poll();
                if(pos.x == 0 || pos.x == C - 1 || pos.y == 0 || pos.y == R - 1)
                    break;
                
                for(int i = 0; i < 4; i++){
                    Position next = new Position(pos.x + dx[i], pos.y + dy[i]);
                    if(next.x < 0 || next.x >= C || next.y < 0 || next.y >= R)
                        continue;
                    if(map[next.y][next.x] != 0)
                        continue;
                    if(visited[next.y][next.x])
                        continue;

                    visited[next.y][next.x] = true;
                    bfs.add(next);
                }
                size--;
            }


            if(size != 0){
                isFind = true;
                break;
            }
        }

        if(isFind)
            System.out.println(answer);
        else
            System.out.println("IMPOSSIBLE");

        
    }
}