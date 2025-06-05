import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dice = new int[4][2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        x = Integer.parseInt(line[2]);
        y = Integer.parseInt(line[3]);
        K = Integer.parseInt(line[4]);

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        line = br.readLine().split(" ");
        int posX = y;
        int posY = x;
        for(int i = 0; i < K; i++){
            int dir = Integer.parseInt(line[i]) - 1;
            int nx = posX + dx[dir];
            int ny = posY + dy[dir];
            if(nx < 0 || ny < 0 || nx >= M || ny >= N)
                continue;
            // 방향에 따른 주사위 회전 로직
            roll(dir);
            // 주사위 밑면과 맵 칸에 대한 교환 로직
            if(map[ny][nx] == 0){
                map[ny][nx] = dice[3][0];
            }
            else{
                dice[3][0] = map[ny][nx];
                dice[3][1] = map[ny][nx];
                map[ny][nx] = 0;
            }

            posX = nx;
            posY = ny;
            System.out.println(dice[1][0]);
        }
    }

    static void roll(int dir){
        int temp = dice[3][0];
        if(dir == 0){ // 동
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = dice[0][1];
            dice[0][1] = temp;
            dice[1][0] = dice[1][1];
            dice[3][0] = dice[3][1];
        }
        else if(dir == 1) { // 서
            dice[3][1] = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = temp;
            dice[1][0] = dice[1][1];
            dice[3][0] = dice[3][1];
        }
        else if(dir == 2){ //북
            dice[3][0] = dice[2][0];
            dice[2][0] = dice[1][0];
            dice[1][0] = dice[0][0];
            dice[0][0] = temp;
            dice[1][1] = dice[1][0];
            dice[3][1] = dice[3][0];
        }
        else { // 남
            dice[3][0] = dice[0][0];
            dice[0][0] = dice[1][0];
            dice[1][0] = dice[2][0];
            dice[2][0] = temp;
            dice[1][1] = dice[1][0];
            dice[3][1] = dice[3][0];
        }
    }
}