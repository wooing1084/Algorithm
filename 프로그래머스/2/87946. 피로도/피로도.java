import java.util.*;

class Solution {
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        int[] visited = new int[dungeons.length];
        
        search(0, k, 0, dungeons, visited);
        
        return answer;
    }
    
    void search(int cnt, int k, int visitCnt, int[][] dungeons, int[] visited){
        if(visitCnt == visited.length){
            answer = Math.max(answer, cnt);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i] == 1)
                continue;
            visited[i] = 1;
            
            if(k >= dungeons[i][0])
                search(cnt + 1, k - dungeons[i][1], visitCnt + 1, dungeons, visited);
            else
                search(cnt, k, visitCnt + 1, dungeons, visited);
            
            visited[i] = 0;
        }
    }
}