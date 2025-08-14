import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] robot = new int[N];

        int answer = 0;
        while(isOk(arr, K)){
            // 1
            int temp = arr[arr.length - 1];
            for(int i = arr.length - 1; i > 0; i--)
                arr[i] = arr[i - 1];
            arr[0] = temp;

            for(int i = robot.length - 1; i > 0; i--)
                robot[i] = robot[i - 1];
            
            robot[0] = 0;
            robot[N - 1] = 0;

            //2
            for(int i = N - 2; i >= 0; i--){
                if(robot[i] == 0)
                    continue;
                if(robot[i + 1] == 1)
                    continue;
                if(arr[i + 1] <= 0)
                    continue;

                arr[i + 1]--;
                robot[i] = 0;
                robot[i + 1] = 1;
            }
            robot[N - 1] = 0;

            //3
            if(arr[0] > 0){
                robot[0] = 1;
                arr[0]--;
            }

            answer++;
        }

        System.out.println(answer);
    }

    static boolean isOk(int[] arr, int K){
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0)
                cnt++;
        }

        return cnt < K;
    }
}