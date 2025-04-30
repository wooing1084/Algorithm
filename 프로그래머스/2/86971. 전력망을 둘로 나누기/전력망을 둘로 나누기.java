import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int[] visited;
    static int cnt = 0;
    public int solution(int n, int[][] wires) {
        visited = new int[n + 1];
        graph = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        
        for(int i = 0; i < wires.length; i++){
            int u = wires[i][0];
            int v = wires[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        int answer = n;
        for(int i = 0; i < wires.length; i++){
            int u = wires[i][0];
            int v = wires[i][1];
            
            graph[u].remove((Integer)v);
            graph[v].remove((Integer)u);
            
            Arrays.fill(visited, 0);
            cnt = 0;
            
            dfs(1);
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        return answer;
    }
    
    void dfs(int idx){
        visited[idx] = 1;
        cnt++;
        for(Integer i : graph[idx]){
            if(visited[i] == 1)
                continue;
            dfs(i);
        }
    }
}