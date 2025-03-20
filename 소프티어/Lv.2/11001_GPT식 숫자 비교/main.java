import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i =0; i < N; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a, b) -> {
            String[] aList = a.split("\\.");
            String[] bList = b.split("\\.");

            int aLeft = Integer.parseInt(aList[0]);
            int bLeft = Integer.parseInt(bList[0]);
            int leftResult = aLeft - bLeft;
            if(leftResult != 0)
                return leftResult;

            int aSize = aList.length;
            int bSize = bList.length;
            int sizeResult = aSize - bSize;
            if(aSize < 2 || bSize < 2)
                return sizeResult;
            
            return Integer.parseInt(aList[1]) - Integer.parseInt(bList[1]);
        });

        StringBuilder builder = new StringBuilder();
        for(String s : arr){
            builder.append(s + "\n");
        }
        System.out.print(builder.toString());
        
    }
}
