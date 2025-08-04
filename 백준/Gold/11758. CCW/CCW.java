import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        int[] p1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] p2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] p3 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
 
        int ccw = p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1] - (p2[0] * p1[1] + p3[0] * p2[1] + p1[0] * p3[1]);

        int answer = 0;
        if(ccw < 0)
            answer = -1;
        else if(ccw > 0)
            answer = 1;

        System.out.println(answer);
        
    }
}