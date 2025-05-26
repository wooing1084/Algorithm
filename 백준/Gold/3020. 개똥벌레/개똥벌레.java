import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int h = Integer.parseInt(line[1]);

        int[] up = new int[n / 2];
        int[] down = new int[n / 2];
        for(int i = 0; i < n; i++){
            if(i % 2 == 0)
                up[i / 2] = Integer.parseInt(br.readLine());
            else
                down[i / 2] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int cnt = 0;
        int min_col = Integer.MAX_VALUE;
        for(int i = 1; i <= h ; i++){
            int collision = bst(i, up) + bst(h - i + 1, down);

            if(min_col > collision){
                min_col = collision;
                cnt = 1;
            }
            else if(min_col == collision){
                cnt++;
            }
        }

        System.out.println(min_col + " " + cnt);
        
    }

    private static int bst(int num, int[] arr){
        int l = 0;
        int r = arr.length;
        while(l < r){
            int mid = (l + r) / 2;
            if(arr[mid] >= num)
                r = mid;
            else
                l = mid + 1;
        }
        return arr.length - r;
    }
}