import java.util.*;

class Solution {
    static int[][] boxes;
    public int solution(int n, int w, int num) {
        num--;
        boxes = new int[n / w + 1][w];
        for(int i = 0; i < boxes.length; i++){
            for(int j = 0; j < w; j++){
                 boxes[i][j] = -1;
            }
        }
        
        for(int i = 0; i < n; i++){
            if((i / w % 2) == 1){
                boxes[i / w][w - (i % w) - 1] = i;
            }
            else
                boxes[i / w][i % w] = i;
        }
        
        for(int i = 0; i < boxes.length; i++){
            for(int j = 0; j < w; j++){
                System.out.print(boxes[i][j] + " ");
            }
            System.out.println();
        }
        
        int row;
        if((num / w % 2) == 1)
            row = w - (num % w) - 1;
        else 
            row = num % w;
        System.out.println(row);
        
        int answer = 0;
        for(int i = num / w; i <= n / w; i++){        
            if(boxes[i][row] != -1){
                System.out.println(boxes[i][row]);
                answer++;
            }
                
        }
    
        return answer;
    }
}