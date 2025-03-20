import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int answer = 0;
    static int maxDepth = 4;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N + 1][N + 1];
        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        if(N == 2)
            maxDepth = 2;
        dfs(0, 0);

        System.out.println(answer);
        
    }

    public static void dfs(int depth, int h){
        if(depth == maxDepth){
            answer = Math.max(h, answer);
            return;
        }
            
        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                if(visited[y][x] == 1)
                    continue;
                for(int i = 0; i < 2; i++){
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if(newX >= N || newY >= N || visited[newY][newX] == 1)
                        continue;

                    visited[newY][newX] = 1;
                    visited[y][x] = 1;
                    dfs(depth + 1, h + map[y][x] + map[newY][newX]);
                    visited[newY][newX] = 0;
                    visited[y][x] = 0;
                }
            }
        }

        
        
    }
}
