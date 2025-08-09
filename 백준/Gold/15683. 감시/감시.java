import java.util.*;
import java.lang.*;
import java.io.*;

class Position{
    int x, y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }

     public boolean equals(Object o){
         if(o == null)
            return false;
         if(this == o)
             return true;
        if(!(o instanceof Position))
            return false;
        Position p = (Position) o;
        return (this.x == p.x && this.y == p.y);
    }

    public int hashCode(){
        return Objects.hash(x, y);
    }
}

class Cctv{
    Position pos;
    int[][] dir; // [방향 갯수][x, y]
    Cctv(Position pos, int type){
        this.pos = pos;
        if(type == 1){
            dir = new int[1][2];
            dir[0][0] = 1;
        }
        else if(type == 2){
            dir = new int[2][2];
            dir[0][0] = 1;
            dir[1][0] = -1;
        }
        else if(type == 3){
            dir = new int[2][2];
            dir[0][1] = -1;
            dir[1][0] = 1;
        }
        else if(type == 4){
            dir = new int[3][2];
            dir[0][0] = -1;
            dir[1][1] = -1;
            dir[2][0] = 1;
        }
        else {
            dir = new int[4][2];
            dir[0][0] = -1;
            dir[1][1] = -1;
            dir[2][0] = 1;
            dir[3][1] = 1;
        }
    }

    void rotate(){
        for(int i = 0; i < dir.length; i++){
            if(dir[i][1] != 0)
                dir[i][1] *= -1;
            
            int temp = dir[i][0];
            dir[i][0] = dir[i][1];
            dir[i][1] = temp;
        }
    }

    void check(Set<Position> cover, int N, int M, int[][] map){
        for(int i = 0; i < dir.length; i++){
            int nextX = pos.x;
            int nextY = pos.y;
            while((nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) && map[nextY][nextX] != 6){
                cover.add(new Position(nextX, nextY));
                nextX += dir[i][0];
                nextY += dir[i][1];
            }
        }
    }
}

class Main {
    static int N, M;
    static int[][] map;
    static List<Cctv> cctvList = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static int wallCnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(line[j]);
                if(map[i][j] == 6)
                    wallCnt++;
                else if(map[i][j] > 0){
                    cctvList.add(new Cctv(new Position(j, i), map[i][j]));
                }
            }
        }

        solve(0, new HashSet<>());

        System.out.println(answer);
        
    }

    static void solve(int idx, Set<Position> cover){
        if(idx == cctvList.size()){
            int cnt = wallCnt + cover.size();
            answer = Math.min(answer, N * M - cnt);
            return;
        }

        Cctv nowCctv = cctvList.get(idx);
        for(int i = 0; i < 4; i++){
            Set<Position> nextCover = new HashSet<>();
            nextCover.addAll(cover);

            nowCctv.check(nextCover, N, M, map);
            solve(idx + 1, nextCover);
            nowCctv.rotate();
        }
    }
}