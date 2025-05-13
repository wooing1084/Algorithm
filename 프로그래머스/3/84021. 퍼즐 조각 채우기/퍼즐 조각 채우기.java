import java.util.*;

class Position{
    int x, y;
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void rotate(){
        int temp = this.x;
        this.x = this.y * -1;
        this.y = temp;
    }
    
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Position np = (Position) o;
        if(this.x == np.x && this.y == np.y) return true;
        return false;
    }
}

class Solution {
    static List<List<Position>> pieces = new ArrayList<>();  
    static List<List<Position>> blanks = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public int solution(int[][] game_board, int[][] table) {
        
        int[][] visited = new int[table.length][table.length];
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table.length; j++){
                if(visited[i][j] == 1 || table[i][j] == 0)
                    continue;
                List<Position> newPiece = new ArrayList<>();
                visited[i][j] = 1;
                dfs(j, i, visited, table, newPiece);
                pieces.add(newPiece);
            }
        }
        
        for(int i = 0; i < game_board.length; i++){
            for(int j = 0; j < game_board.length; j++){
                if(game_board[i][j] == 1)
                    game_board[i][j] = 0;
                else
                    game_board[i][j] = 1;
            }
        }
        
        int[][] board_visited = new int[game_board.length][game_board.length];
        for(int y = 0; y < game_board.length; y++){
            for(int x = 0; x< game_board.length; x++){
                if(board_visited[y][x] == 1 || game_board[y][x] == 0)
                    continue;
                
                List<Position> newBlank = new ArrayList<>();
                board_visited[y][x] = 1;
                dfs(x, y, board_visited, game_board, newBlank);
                int minX = Integer.MAX_VALUE;
                int minY = Integer.MAX_VALUE;
                for(Position p : newBlank){
                    minX = Math.min(minX, p.x);
                    minY = Math.min(minY, p.y);
                }
                for(Position p : newBlank){
                    p.x -= minX;
                    p.y -= minY;
                }
                    
                blanks.add(newBlank);      
            }
        }
        
        int answer = 0;
        for(List<Position> piece : pieces){
            for(int i = 0; i < 4; i++){
                int minX = Integer.MAX_VALUE;
                int minY = Integer.MAX_VALUE;
                for(Position p : piece){
                    p.rotate();
                    minX = Math.min(minX, p.x);
                    minY = Math.min(minY, p.y);
                }
                
                for(Position p : piece){
                    p.x -= minX;
                    p.y -= minY;
                }  
                
                List<Position> foundBlank = null;
                for(List<Position> blank : blanks){
                    if(blank.size() != piece.size())
                        continue;
                    if(blank.containsAll(piece)){
                        answer += blank.size();
                        foundBlank = blank;
                        break;    
                    }
                }
                
                if(foundBlank != null){
                    blanks.remove(foundBlank);
                    break;
                }
                    
            }
        }
        
        return answer;
    }
    
    
    
    void dfs(int x, int y, int[][] visited, int[][] table, List<Position> piece){
        piece.add(new Position(x, y));
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= table.length || ny < 0 || ny >= table.length)
                continue;
            if(visited[ny][nx] == 1 || table[ny][nx] == 0)
                continue;
            
            visited[ny][nx] = 1;
            dfs(nx, ny, visited, table, piece);
        }
    }
}