import java.util.Stack;

class Solution {
    static boolean[] visited;
    static int N;
    
    public int dfs(int n, int[][] computers){
        if(visited[n])
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        visited[n] = true;
        
        while(!stack.empty()){
            int idx = stack.pop();
            
            for(int i = 0; i < N; i++){
                if(visited[i] == false && computers[idx][i] == 1){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        
        return 1;
    }
    
    public int solution(int n, int[][] computers) {
        N = n;
        visited = new boolean[n];
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            answer += dfs(i, computers);
        }
        
        return answer;
    }
}