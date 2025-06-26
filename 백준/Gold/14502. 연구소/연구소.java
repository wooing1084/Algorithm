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
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int M;
    static int wallCnt = 0;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        int[][] map = new int[N][M];
        List<Position> virus = new ArrayList<>();
        for(int i = 0; i < N; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                int n = Integer.parseInt(line[j]);
                map[i][j] = n;

                if(n == 2)
                    virus.add(new Position(j, i));
                if(n == 1)
                    wallCnt++;
            }
        }
        
        for(int i = 0; i < N * M - 2; i++){
            if(map[i / M][i % M] == 1 || map[i / M][i % M] == 2)
                continue;

            map[i / M][i % M] = 1;
            for(int j = i + 1; j < N * M - 1; j++){
                if(map[j / M][j % M] == 1 || map[j / M][j % M] == 2)
                    continue;

                map[j / M][j % M] = 1;
                for(int k = j + 1; k < N * M; k++){
                    if(map[k / M][k % M] == 1 || map[k / M][k % M] == 2)
                        continue;
                    
                    map[k / M][k % M] = 1;
                    contagious(map, virus);
                    map[k / M][k % M] = 0;
                }
                map[j / M][j % M] = 0;
            }
            map[i / M][i % M] = 0;
        }

        System.out.println(answer);
    }

    static void contagious(int[][] map,  List<Position> virus){
        Stack<Position> stack = new Stack<>();
        int[][] visited = new int[N][M];
        for(Position p : virus){
             stack.push(p);
            visited[p.y][p.x] = 1;
        }
        
        int cnt = stack.size();
        while(!stack.isEmpty()){
            Position v = stack.pop();
            for(int i = 0; i < 4; i++){
                Position nv = new Position(v.x + dx[i], v.y + dy[i]);
                if(nv.x < 0 || nv.x >= M || nv.y < 0 || nv.y >= N)
                    continue;
                if(visited[nv.y][nv.x] != 0 || map[nv.y][nv.x] != 0)
                    continue;

                cnt++;
                visited[nv.y][nv.x] = 1;
                stack.add(nv);
            }
        }

        answer = Math.max(answer, N * M - cnt - wallCnt - 3);
    }
}