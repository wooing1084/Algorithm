import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] wheels = new int[4];
        for(int i = 0; i < 4; i++){
            wheels[i] = Integer.parseInt(br.readLine(), 2);
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int[] op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] visited =new int[4];
            visited[op[0] - 1] = 1;
            rotate(op[0] - 1, op[1], visited, wheels);
        }

        int answer = 0;
        int point = 1;
        for(int i = 0; i < 4; i++){
            if(((wheels[i] >> 7) & 1) == 1)
                answer += point;

            point *= 2;
        }

        System.out.println(answer);
    }

    static void rotate(int idx, int dir, int[] rotated, int[] wheels){
        //l: 2, r: 6
        int[] di = {-1, 1};
        for(int i = 0; i < di.length; i++){
            int nIdx = idx + di[i];
            if(nIdx < 0 || nIdx >= wheels.length)
                continue;
            if(rotated[nIdx] == 1)
                continue;

            int leftWheelBit;
            int rightWheelBit;
            if(i == 0){
                leftWheelBit = (wheels[nIdx] >> 5) & 1;
                rightWheelBit = (wheels[idx] >> 1) & 1;
            }
            else{
                leftWheelBit = (wheels[idx] >> 5) & 1;
                rightWheelBit = (wheels[nIdx] >> 1) & 1;
            }

            if(leftWheelBit == rightWheelBit)
                continue;

            rotated[nIdx] = 1;
            rotate(nIdx, dir * -1, rotated, wheels);
        }
        if(dir == 1){
            wheels[idx] = (wheels[idx] >>> 1) | (wheels[idx] << 7); 
            wheels[idx] &= 0xFF;
        }
        else {
            wheels[idx] = (wheels[idx] << 1) | (wheels[idx] >> 7);
            wheels[idx] &= 0xFF;
        }
            
    }
}