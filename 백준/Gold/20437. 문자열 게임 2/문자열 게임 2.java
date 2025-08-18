import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            solve(br.readLine(), Integer.parseInt(br.readLine()));
        }
        
    }

    static void solve(String str, int k){
        if(k == 1){
            System.out.println("1 1");
            return;
        }
            
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;

        int[] alphaCnt = new int[26];
        List<List<Integer>> alphaIndices = new ArrayList<>();
        for(int i = 0; i < 26; i++)
            alphaIndices.add(new ArrayList<Integer>());

        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';
            alphaCnt[idx]++;
            alphaIndices.get(idx).add(i);
        }

        for(int i = 0; i < 26; i++){
            if(alphaIndices.get(i).size() < k)
                continue;

            for(int j = 0; j <= alphaIndices.get(i).size() - k; j++){
                int l = alphaIndices.get(i).get(j);
                int r = alphaIndices.get(i).get(j + k - 1);
                int len = r - l + 1;

                minLen = Math.min(minLen, len);
                maxLen = Math.max(maxLen, len);
            }
        }

        if(minLen == Integer.MAX_VALUE || maxLen == Integer.MIN_VALUE)
            System.out.println(-1);
        else
            System.out.println(minLen + " " + maxLen);
        
    }
}