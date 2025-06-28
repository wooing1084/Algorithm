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
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] map;
    static List<Position> houseList = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        
        map = new int[N][N];
        List<Position> chickenList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(line[j]);

                if(map[i][j] == 1)
                    houseList.add(new Position(j + 1, i + 1));
                else if(map[i][j] == 2)
                    chickenList.add(new Position(j + 1, i + 1));
            }
        }

        for(int i = M; i > 0; i--){
            backtrack(0, -1, i, chickenList, new Position[i]);
        }

        System.out.print(answer);
    }

    static void backtrack(int cnt, int idx, int m, List<Position> origin, Position[] newArray){
        if(cnt == m){
            compute(List.of(newArray));
            return;
        }

        for(int i = idx + 1; i < origin.size(); i++){
            newArray[cnt] = origin.get(i);
            backtrack(cnt + 1, i, m, origin, newArray);
        }
            
    }

    static void compute(List<Position> chickenList){
        int cnt = 0;
        for(Position p : houseList){
            int minDist = Integer.MAX_VALUE;
            for(Position cp : chickenList){
                int dist = Math.abs(p.x - cp.x) + Math.abs(p.y - cp.y);
                minDist = Math.min(minDist, dist);
            }
            cnt += minDist;
            if(cnt >= answer)
                return;
        }

        answer = cnt;
    }

    
}