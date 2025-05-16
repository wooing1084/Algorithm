import java.util.*;

class Solution {
    static int[][] adjMat;
    public int solution(int n, int[][] results) {
        adjMat = new int[n + 1][n + 1];
        for(int i = 0; i < results.length; i++){
            adjMat[results[i][0]][results[i][1]] = 1;
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++){
            int[] visited = new int[n + 1];
            visited[i] = 1;
            
            Queue<Integer> winQueue = new LinkedList<>();
            Queue<Integer> loseQueue = new LinkedList<>();
            int winSize = 0;
            int loseSize = 0;
            for(int j = 1; j <= n; j++){
                if(adjMat[i][j] == 1){
                    winQueue.add(j);
                    visited[j] = 1;
                    winSize++;
                }
                else if(adjMat[j][i] == 1){
                    loseQueue.add(j);
                    visited[j] = 1;
                    loseSize++;
                }
                    
            }
            

            while(!winQueue.isEmpty()){
                int winner = winQueue.poll();
                for(int j = 0; j <= n; j++){
                    if(visited[j] != 1 && adjMat[winner][j] == 1){
                        visited[j] = 1;
                        winQueue.add(j);
                        winSize++;
                    }
                }
            }
            
            while(!loseQueue.isEmpty()){
                int loser = loseQueue.poll();
                for(int j = 0; j <= n; j++){
                    if(visited[j] != 1 && adjMat[j][loser] == 1){
                        visited[j] = 1;
                        loseQueue.add(j);
                        loseSize++;
                    }
                }
            }
            
            if(winSize + loseSize == n - 1)
                answer++;  
        }
        
        return answer;
    }
}