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
        if(!(o instanceof Position))
            return false;
        Position p = (Position) o;
        return (this.x == p.x && this.y == p.y);
    }

    public int hashCode(){
        return Objects.hash(x, y);
    }
}

class Main {
    static int N;
    static int[][] map;
    static int[] sitX;
    static int[] sitY;
    static int[][] likes;
    static int[] sit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        sit = new int[N * N];
        sitX = new int[N * N + 1];
        sitY = new int[N * N + 1];
        likes = new int[N * N + 1][4];
        
        for(int i = 0; i < N * N; i++){
            String[] line = br.readLine().split(" ");
            sit[i] = Integer.parseInt(line[0]);
            for(int j = 1; j <= 4; j++){
                likes[sit[i]][j - 1] = Integer.parseInt(line[j]);
            }
        }

        for(int i = 0; i < N * N; i++){
            Map<Position, Integer> likeMap = new HashMap<>();
            int nowIdx = sit[i];
            
            for(int j = 0; j < 4; j++){
                int likeIdx = likes[nowIdx][j];
                if(sitX[likeIdx] == 0 && sitY[likeIdx] == 0)  // 아직 배치되지 않은 학생
                    continue;

                for(int k = 0; k < 4; k++){
                    Position nextPos = new Position(sitX[likeIdx] + dx[k], sitY[likeIdx] + dy[k]);
                    if(nextPos.x <= 0 || nextPos.x > N || nextPos.y <= 0 || nextPos.y > N)
                        continue;
                    if(map[nextPos.y][nextPos.x] != 0)  // 이미 배치된 자리는 제외
                        continue;
                        
                    int cnt = likeMap.getOrDefault(nextPos, 0);
                    likeMap.put(nextPos, cnt + 1);
                }
            }

            Position next;
            if(likeMap.isEmpty()){
                Map<Integer, PriorityQueue<Position>> available = new HashMap<>();

                int maxCnt = 0;
                for(int j = 1; j <= N; j++){
                    for(int k = 1; k <= N; k++){
                        if(map[j][k] != 0)
                            continue;

                        Position p = new Position(k, j);
                        int cnt = 0;
                        for(int l = 0; l < 4; l++){
                            Position np = new Position(p.x + dx[l], p.y + dy[l]);
                            if(np.x <= 0 || np.x > N || np.y <= 0 || np.y > N)
                                continue;

                            if(map[np.y][np.x] == 0)
                                cnt++;
                        }

                        maxCnt = Math.max(maxCnt, cnt);
                        PriorityQueue<Position> pq = available.getOrDefault(cnt, new PriorityQueue<Position>((a, b) -> {
                            if(a.y == b.y)
                                return a.x - b.x;
                            return a.y - b.y;
                        }));

                        pq.add(p);
                        available.put(cnt, pq);
                    }
                }

                next = available.get(maxCnt).poll();
            }
            else{
                Map<Position, Integer> emptyMap = new HashMap<>();
                
                // 좋아하는 학생 수가 같은 자리들 중에서 빈 자리 수로 다시 필터링
                int maxLikeCnt = 0;
                for(int cnt : likeMap.values()){
                    maxLikeCnt = Math.max(maxLikeCnt, cnt);
                }
                
                for(Position p : likeMap.keySet()){
                    if(likeMap.get(p) != maxLikeCnt)
                        continue;
                        
                    int emptyCnt = 0;
                    for(int l = 0; l < 4; l++){
                        Position np = new Position(p.x + dx[l], p.y + dy[l]);
                        if(np.x <= 0 || np.x > N || np.y <= 0 || np.y > N)
                            continue;
                        if(map[np.y][np.x] == 0)
                            emptyCnt++;
                    }
                    emptyMap.put(p, emptyCnt);
                }
                
                int maxEmptyCnt = 0;
                for(int cnt : emptyMap.values()){
                    maxEmptyCnt = Math.max(maxEmptyCnt, cnt);
                }
                
                PriorityQueue<Position> pq = new PriorityQueue<>((a, b) -> {
                    if(a.y == b.y)
                        return a.x - b.x;
                    return a.y - b.y;
                });
                
                for(Position p : emptyMap.keySet()){
                    if(emptyMap.get(p) == maxEmptyCnt){
                        pq.add(p);
                    }
                }

                next = pq.poll();
            }
            
            map[next.y][next.x] = nowIdx;
            sitX[nowIdx] = next.x;
            sitY[nowIdx] = next.y;
        }

        int answer = 0;
        for(int i = 0; i < N * N; i++){
            int nx = sitX[sit[i]];
            int ny = sitY[sit[i]];

            int cnt = 0;
            for(int j = 0; j < 4; j++){
                int lx = sitX[likes[sit[i]][j]];
                int ly = sitY[likes[sit[i]][j]];  // 수정: sitX -> sitY

                // 수정: 인접한 칸인지 확인 (맨해튼 거리 1)
                if(Math.abs(nx - lx) + Math.abs(ny - ly) == 1)
                    cnt++;
            }
            
            if(cnt == 1)
                answer += 1;
            else if(cnt == 2)
                answer += 10;
            else if(cnt == 3)
                answer += 100;
            else if(cnt == 4)
                answer += 1000;
        }

        System.out.println(answer);
    }
}