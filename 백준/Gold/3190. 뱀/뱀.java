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
    static int N, K, L;
    static int[][] map;
    static int[] opTime;
    static int[] dx = {1, 0, -1, 0}; // 0: 우, 1: 하, 2: 좌, 3: 상
    static int[] dy = {0, 1, 0, -1};
    static String[] ops;
    static Deque<Position> snake = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        map[1][1] = 2;
        snake.addFirst(new Position(1, 1));
        
        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            String[] line = br.readLine().split(" ");
            map[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = 1;
        }

        L = Integer.parseInt(br.readLine());
        opTime = new int[L + 1];
        ops = new String[L + 1];
        for(int i = 0; i < L; i++){
            String[] line = br.readLine().split(" ");
            opTime[i] = Integer.parseInt(line[0]);
            ops[i] = line[1];
        }

        int time = 0;
        int opsIdx = 0;
        int dir = 0;
        while(true){
            time++;

            Position head = snake.peekFirst();
            Position newHead = new Position(head.x + dx[dir], head.y + dy[dir]);
            snake.addFirst(newHead);
            if(newHead.x <= 0 || newHead.y <= 0 || newHead.x > N || newHead.y > N)
                break;
            
            if(map[newHead.y][newHead.x] == 2)
                break;

            if(map[newHead.y][newHead.x] != 1){
                Position tail = snake.pollLast();
                map[tail.y][tail.x] = 0;
            }

            map[newHead.y][newHead.x] = 2;

            if(opTime[opsIdx] == time){
                if(ops[opsIdx].equals("D"))
                    dir++;
                else
                    dir--;

                dir = (dir + 4) % 4;
                opsIdx++;
            }
        }

        System.out.println(time);
        
    }
}