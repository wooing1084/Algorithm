import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String[] ops = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            int[] arr;
            if(n == 0)
                arr = new int[0];
            else 
                arr = Arrays.stream(line.substring(1, line.length() - 1).split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int idx = 0;
            int l = 0;
            int r = arr.length - 1;
            boolean dir = false; // 0: 정방향, 1: 역방향
            for(idx = 0; idx < ops.length; idx++){
                String op = ops[idx];
                if(op.equals("R"))
                    dir = !dir;
                else if(op.equals("D")){
                    if(l > r || n == 0)
                        break;
                    if(dir){
                        r--;
                    }
                    else
                        l++;
                }
            }

            StringBuilder sb = new StringBuilder();
            if(idx != ops.length)
                sb.append("error");
            else {
                sb.append("[");
                if(l <= r){
                    if(dir){
                        for(int s = r; s > l; s--)
                            sb.append(arr[s] + ",");
                        sb.append(arr[l]);
                    }
                    else {
                        for(int s = l; s < r; s++)
                            sb.append(arr[s] + ",");
                        sb.append(arr[r]);
                    }
                    
                }
                sb.append("]");
            }

            System.out.println(sb.toString());
        }
    }
}