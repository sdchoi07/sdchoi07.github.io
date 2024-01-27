import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(score);
        for(int i = score.length-1; i >=0; i--){
            list.add(score[i]);
            if(list.size() == m){
                Collections.sort(list);
                answer += list.get(0) * m ;
                list.removeAll(list);
            }

        }

        return answer;
    }
}