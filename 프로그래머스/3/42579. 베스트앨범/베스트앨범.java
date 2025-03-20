import java.io.*;
import java.util.*;

class Music{
    Integer idx;
    Integer play;
    Music(int idx, int play){
        this.idx = idx;
        this.play = play;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total_play_map = new HashMap<>();
        Map<String, PriorityQueue<Music>> music_list_map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            Music m = new Music(i, play);
            
            total_play_map.put(genre, total_play_map.getOrDefault(genre, 0) + play);
            if(!music_list_map.containsKey(genre)){
                PriorityQueue<Music> q = new PriorityQueue<>((o1, o2) -> {
                    if(o1.play == o2.play)
                        return 1;
                    return o2.play - o1.play;
                });
                music_list_map.put(genre, q);
            }
            music_list_map.get(genre).add(m);
        }
        
        List<String> keySet = new ArrayList<>(total_play_map.keySet());
        List<Integer> answer = new ArrayList<>();
        keySet.sort((o1, o2) -> {
            return total_play_map.get(o2) - total_play_map.get(o1);
        });
        for(String k : keySet) {
            PriorityQueue<Music> q = music_list_map.get(k);
            answer.add(q.poll().idx);
            if(q.isEmpty())
                continue;
            answer.add(q.poll().idx);
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}