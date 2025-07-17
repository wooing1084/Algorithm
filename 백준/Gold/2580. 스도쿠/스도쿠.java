import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map = new int[9][9];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < 9; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        sudoku(0, 0);

    }

    static void sudoku(int row, int col){
        if(col == 9){
            sudoku(row + 1, 0);
            return;
        }

        if(row == 9){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        if(map[row][col] == 0){
            for(int i = 1; i <= 9; i++){
                if(isPossible(row, col, i)){
                    map[row][col] = i;
                    sudoku(row, col + 1);
                }
            }    

            map[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }

    static boolean isPossible(int row, int col, int n){
        int gridStartRow = (row / 3) * 3;
        int gridStartCol = (col / 3) * 3;
        
        for(int i = 0; i < 9; i++){
            if(i != row && map[i][col] == n)
                return false;
            if(i != col && map[row][i] == n)
                return false;
            if(map[gridStartRow + (i / 3)][gridStartCol + (i % 3)] == n)
                return false;
        }

        return true;
    }
}