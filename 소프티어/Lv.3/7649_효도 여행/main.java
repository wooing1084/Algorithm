import java.io.*;
import java.util.*;

public class Main {
    static class Edge{
        int v;
        char c;
        Edge(int v, char c){
            this.v = v;
            this.c = c;
        }
    }
    
    static int N, M;
    static String S;
    static List<List<Edge>> adj;
    static int[] visited;
    static int[][] dp = new int[5001][5001];
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        N = Integer.parseInt(first[0]);
        M = Integer.parseInt(first[1]);
        S = br.readLine();        
        visited = new int[N];

        adj = new ArrayList<>();
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < N - 1; i++){
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]) - 1;
            int v = Integer.parseInt(line[1]) - 1;
            char c = line[2].charAt(0);

            adj.get(u).add(new Edge(v, c));
            adj.get(v).add(new Edge(u, c));
        }
        
        visited[0] = 1;
        dfs(0, 0, ' ');

        System.out.print(answer);
    }

    static void dfs(int idx, int depth, char c){
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == c)
                dp[depth + 1][i + 1] = dp[depth][i] + 1;
            else
                dp[depth + 1][i + 1] = Math.max(dp[depth + 1][i], dp[depth][i + 1]);
            answer = Math.max(dp[depth + 1][i + 1], answer);
        }
        
        for(int i = 0; i < adj.get(idx).size(); i++){
            Edge e = adj.get(idx).get(i);
            if(visited[e.v] == 1)
                continue;

            visited[e.v] = 1;
            dfs(e.v, depth + 1, e.c);
            visited[e.v] = 0;
        }
    }
}
