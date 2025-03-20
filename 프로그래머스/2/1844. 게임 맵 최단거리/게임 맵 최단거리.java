import java.util.Queue;
import java.util.LinkedList;

class Solution {
    class Pair{
        int x, y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    boolean[][] visited;
    int N;
    int M;
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int bfs(int[][] maps){
        Queue<Pair> q1 = new LinkedList<>();
        Queue<Pair> q2 = new LinkedList<>();
        
        q1.add(new Pair(0, 0));
        visited[0][0] = true;
        
        int cnt = 1;
        while(!q1.isEmpty()){
            Pair pos = q1.poll();
            if(pos.x == M - 1 && pos.y == N - 1){
                break;
            }
            
            for(int i = 0; i< 4; i++){
                int newX = pos.x + dx[i];
                int newY = pos.y + dy[i];
                
                if(newX >= 0 && newY >= 0 && newX < M && newY < N){
                    if(!visited[newY][newX] && maps[newY][newX] == 1){
                        q2.add(new Pair(newX, newY));
                        visited[newY][newX] = true;
                    }
                }
            }
            
            if(q1.isEmpty()){
                if(q2.isEmpty()){
                    cnt = -1;
                }
                else {
                    q1.addAll(q2);
                    q2.clear();
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        visited = new boolean[N][M];
        
        int answer = bfs(maps);
        return answer;
    }
}