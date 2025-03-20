import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int[] command = commands[i];
            int[] arr = Arrays.copyOf(array, array.length);
            Arrays.sort(arr, command[0] - 1, command[1]);
            answer[i] = arr[command[0] - 1 + command[2] - 1];
        }
        
        return answer;
    }
}