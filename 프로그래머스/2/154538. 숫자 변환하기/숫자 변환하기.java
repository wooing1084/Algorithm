import java.util.*;

class Solution {
    static int[] visited;
    public int solution(int x, int y, int n) {
        visited = new int[y + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 0});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == y)
                return now[1];
            
            if(now[0] + n <= y){
                if(visited[now[0] + n] != 1){
                    visited[now[0] + n] = 1;
                    q.add(new int[]{now[0] + n, now[1] + 1});
                }   
            }
            if(now[0] * 2 <= y){
                if(visited[now[0] * 2] != 1){
                    visited[now[0] * 2] = 1;
                    q.add(new int[]{now[0] * 2, now[1] + 1});
                }   
            }
            if(now[0] * 3 <= y){
                if(visited[now[0] * 3] != 1){
                    visited[now[0] * 3] = 1;
                    q.add(new int[]{now[0] * 3, now[1] + 1});
                }   
            }
        }
        
        
        return -1;
    }
    
}