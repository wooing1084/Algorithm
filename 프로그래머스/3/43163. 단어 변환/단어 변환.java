import java.util.LinkedList;
import java.util.Queue;

public class Data {
    String word;
    int count;

    public Data(String word, int count) {
        this.word = word;
        this.count = count;
    }

}

class Solution {

    public int solution(String begin, String target, String[] words) {
        Queue<Data> queue = new LinkedList<>();
        queue.offer(new Data(begin, 0));
        boolean[] visited = new boolean[words.length];

        while (!queue.isEmpty()){
            Data data = queue.poll();
            if (data.word.equals(target)) {
                return data.count;
            }

            for (int i = 0; i < words.length; i++){
                if (!visited[i] && check(data.word, words[i])){
                    queue.offer(new Data(words[i], data.count + 1));
                    visited[i] = true;
                }
            }      
        }

        return 0;
    }


    private boolean check(String first, String second){
        int cnt = 0;

        for (int i = 0; i < first.length(); i++){
            if (first.charAt(i) != second.charAt(i)) cnt++;
        }

        return cnt == 1 ? true : false;
    }

}