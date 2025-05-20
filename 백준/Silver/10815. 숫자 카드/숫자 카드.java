import java.util.*;
import java.io.*;


public class Main{
     public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr1 = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr1);
         
        int m = Integer.parseInt(br.readLine());
        line = br.readLine().split(" ");
        int[] arr2 = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();

        int[] answer = new int[arr2.length];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr2.length; i++){
            int s = 0;
            int e = n - 1;
            
            while(s <= e){
                int mid = (e + s) / 2;
                if(arr1[mid] < arr2[i])
                    s = mid + 1;
                else if(arr1[mid] > arr2[i])
                    e = mid - 1;
                else{
                    answer[i] = 1;
                    break;
                }
            }

            sb.append(answer[i] + " ");
        }

         System.out.println(sb.toString());
         
     }
}