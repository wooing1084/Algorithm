import java.util.*;

class Solution {
    static String[] numArr;
    static Set<Integer> primeSet = new HashSet<>();
    static boolean[] used;
    public int solution(String numbers) {
        numArr = numbers.split("");
        used = new boolean[numArr.length];
        comb(0, 0, numArr.length, new StringBuilder());
        return primeSet.size();
    }
    
    void comb(int depth, int idx, int maxDepth, StringBuilder sb){
        if(depth == maxDepth) {
            return;
        }
        
        for(int i = 0; i < numArr.length; i++){
            if(depth == 0 && numArr[i].equals("0"))
                continue;
            if(used[i])
                continue;
            
            used[i] = true;
            sb.append(numArr[i]);
            int num = Integer.parseInt(sb.toString());
            if(isPrime(num))
                primeSet.add(num);
            comb(depth + 1, i, maxDepth, sb);
            sb.deleteCharAt(depth);
            used[i] = false;
        }
    }
    
    boolean isPrime(int n){
        if(n <= 1)
            return false;
        for(int i = 2; i <= n / 2; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}