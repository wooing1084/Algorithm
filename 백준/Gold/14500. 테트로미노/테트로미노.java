import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N,M, answer = 0;
    static int[][] map;
    // 5, 4, 2(y, x)
    static int[][][] terminos = {
        {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
        {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
        {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 1}}
    };
    static int[][] flip = {
        {1, 1},
        {1, -1},
        {-1, 1}
    };
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
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sum(j, i);
            }
        }

        System.out.println(answer);
        
    }

    static void sum(int x, int y){
        for(int tIdx = 0; tIdx < 5; tIdx++){
            for(int fIdx = 0; fIdx < 3; fIdx++){
                int[][] termino = new int[4][2];
                for(int i = 0; i < 4; i++){
                    termino[i][0] = terminos[tIdx][i][0] * flip[fIdx][0];
                    termino[i][1] = terminos[tIdx][i][1] * flip[fIdx][1];
                }

                for(int rIdx = 0; rIdx < 4; rIdx++){
                    int sum = 0;
                    int i;
                    for(i = 0; i < 4; i++){
                        int ny = y + termino[i][0];
                        int nx = x + termino[i][1];
                        if(nx < 0 || nx >= M || ny < 0 || ny >= N)
                            break;
                        sum += map[ny][nx];
                    }
                    if(i == 4)
                        answer = Math.max(answer, sum);

                    for(i = 0; i < 4; i++){
                        int temp = termino[i][0];
                        termino[i][0] = termino[i][1];
                        termino[i][1] = temp * -1;
                    }
                }
            }
        }
        
    }
}