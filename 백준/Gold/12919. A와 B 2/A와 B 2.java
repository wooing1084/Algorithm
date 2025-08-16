import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        solve(T, S);
        System.out.println(answer);
    }

    static void solve(String t, String s){
        if(t.length() <= s.length()){
            if(t.equals(s))
                answer = 1;
            return;
        }

        if(t.charAt(t.length() - 1) == 'A'){
            solve(t.substring(0, t.length() - 1), s);
        }
        if(t.charAt(0) == 'B'){
            StringBuilder sb = new StringBuilder(t.substring(1));
            sb.reverse();
            solve(sb.toString(), s);
        }
    }
}