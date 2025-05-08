import java.util.*;

class Solution {
    static int[] parents;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            if(a[2] == b[2])
                return a[0] - b[0];
            return a[2] - b[2];
        }); 
        
        int answer = 0;
        parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++){            
            int src = costs[i][0];
            int dest = costs[i][1];
            if(find(src) != find(dest)){
                union(src, dest);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    int find(int n){
        if(parents[n] != n)
            parents[n] = find(parents[n]);
        return parents[n];
    }
    
    void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a < b)
            parents[b] = a;
        else 
            parents[a] = b;
    }
    
    
}