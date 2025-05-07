import java.util.*;

class Solution {
    class Node{
        int e, w;
        Node(int e, int w){
            this.e = e;
            this.w = w;
        }
    }
    static List<List<Node>> adj = new ArrayList<>();
    public int solution(int n, int[][] costs) {
        // 다익스트라
        // 다익스트라 저장 값 [cost, 마지막 방문 노드 (없으면 -1)]
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<Node>());
        for(int i = 0; i < costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            
            adj.get(a).add(new Node(b, c));
            adj.get(b).add(new Node(a, c));
        }
        
        int[] visited = new int[n];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.w - b.w;
        });
        
        visited[0] = 1;
        for(Node node : adj.get(0)){
            pq.add(node);
        }
        
        int answer = 0;
        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            
            if(visited[nowNode.e] == 1)
                continue;
            answer += nowNode.w;
            visited[nowNode.e] = 1;
            for(Node next : adj.get(nowNode.e)){
                pq.add(next);
            }
        }
        
        return answer;
    }
    
    
}