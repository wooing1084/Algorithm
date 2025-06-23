import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            System.out.println(palindrome(line, 0, line.length() - 1, 0));
        }
    }

    static int palindrome(String str, int l, int r, int cnt){
        while(l < r){
            if(str.charAt(l) == str.charAt(r)){
                l++;
                r--;
                continue;
            }

            cnt++;
            if(cnt >= 2)
                return 2;

            int res = palindrome(str, l + 1, r, cnt);
            if(res == cnt){
                l++;
                continue;
            }
                

            res = palindrome(str, l, r - 1, cnt);
            if(res == cnt){
                r--;
                continue;
            }
        }
        
        return cnt;
    }
}