import java.util.*;

class Solution {
    static boolean[] used;
    static List<String> paths = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        StringBuilder sb = new StringBuilder();
        sb.append("ICN");
        dfs("ICN", sb, 0, tickets);
        
        Collections.sort(paths);

        return paths.get(0).split(" ");
    }
    
    void dfs(String start, StringBuilder path, int cnt, String[][] tickets){
        if(cnt >= tickets.length){
            paths.add(path.toString());
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!used[i] && tickets[i][0].equals(start)){
                used[i] = true;
                path.append(" ");
                path.append(tickets[i][1]);
                dfs(tickets[i][1], path, cnt + 1, tickets);
                path.delete(path.length() - 4, path.length());
                used[i] = false;
            }
        }
    }
}