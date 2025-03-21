import java.util.*;

class Solution {
    static int[][] map = new int[101][101];
    static int[][] visited = new int[101][101];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        for(int i = 0; i < rectangle.length; i++){
            int lx = rectangle[i][0] * 2;
            int ly = rectangle[i][1] * 2;
            int rx = rectangle[i][2] * 2;
            int ry = rectangle[i][3] * 2;
            
            for(int y = ly; y <= ry; y++){
                for(int x = lx; x <= rx; x++){
                    if(x == lx || x == rx || y == ly || y == ry){
                        if(map[y][x] == 0)
                            map[y][x] = 1;
                    }
                    else
                        map[y][x] = 2;
                }
            }
        }
        
        visited[characterY * 2][characterX * 2] = 1;
        dfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2, 0);
        
        return answer / 2;
    }
    
    static void dfs(int posX, int posY, int targetX, int targetY, int cnt){
        if(posX == targetX && posY == targetY){
            answer = Math.min(answer, cnt);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int nX = posX + dx[i];
            int nY = posY + dy[i];
            
            if(nX < 0 || nX > 100 || nY < 0 || nY > 100)
                continue;
            else if(map[nY][nX] == 1 && visited[nY][nX] == 0){
                visited[nY][nX] = 1;
                dfs(nX,nY, targetX, targetY, cnt + 1);
                visited[nY][nX] = 0;
            }
            

        }
    }
}