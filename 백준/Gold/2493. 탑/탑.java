import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<int[]> stack = new Stack<>();
        for(int i = 1; i <= n; i++){
            int top = arr[i - 1];
            while(!stack.isEmpty()){
                if(stack.peek()[1] > top){
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                else
                    stack.pop();
            }
            if(stack.isEmpty())
                System.out.print("0 ");
            stack.add(new int[] {i, top});
        }
    }
}