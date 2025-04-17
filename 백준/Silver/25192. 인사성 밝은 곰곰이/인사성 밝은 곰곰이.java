import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        
        Set<String> set = new HashSet<>();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            if(line.equals("ENTER")){
                cnt += set.size();
                set.clear();
            }
            else{
                set.add(line);
            }
        }

        cnt += set.size();
        System.out.println(cnt);
    }
}