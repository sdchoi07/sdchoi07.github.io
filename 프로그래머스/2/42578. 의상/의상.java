import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ;i < clothes.length;i++){
            String[] cloth = clothes[i];
            map.put(cloth[1], map.getOrDefault(cloth[1],0)+1);
        }
        int cnt = 1;
        for (String key : map.keySet()) {
            cnt *= (map.get(key)+1);
        }
        answer = cnt -1;

        return answer;
    }
}