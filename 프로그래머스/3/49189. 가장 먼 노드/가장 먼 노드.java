import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1];
        queue.add(1);
        visited[1] = 1;
        int answer = 0;
        while(!queue.isEmpty()){
            answer = queue.size();
            for(int i = 0; i < answer; i++){
                int idx = queue.poll();
                for(Integer next : adjList.get(idx)){
                    if(visited[next] == 1)
                        continue;
                    
                    visited[next] = 1;
                    queue.add(next);
                }
            }
        }
        
        return answer;
    }
}