import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {1, -1 , 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");    
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int ans = 0;
        for(int i = 0; i < 100; i++){
            int[][] visited = new int[N][N];
            int cnt = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(map[j][k] <= i || visited[j][k] == 1)
                        continue;
                    cnt++;
                    visited[j][k] = 1;
                    dfs(map, visited, k, j, i, N);
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }

    static void dfs(int[][] map, int[][] visited, int x, int y, int h, int N){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if(map[ny][nx] <= h || visited[ny][nx] == 1)
                continue;

            visited[ny][nx] = 1;
            dfs(map, visited, nx, ny, h, N);
        }
    }
}