import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        
        Set<String> set = new TreeSet<>(Comparator.reverseOrder());
        for(int i = 0; i < n; i++){
            String[] line = br.readLine().split(" ");
            if(line[1].equals("enter")){
                set.add(line[0]);
            }
            else{
                set.remove(line[0]);
            }
        }

        String[] arr = set.toArray(new String[0]);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}