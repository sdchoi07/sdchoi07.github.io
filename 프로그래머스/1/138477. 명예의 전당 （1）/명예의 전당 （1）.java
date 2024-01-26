import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
       int[] answer = new int[score.length];
        List<Integer> scores= new ArrayList<>();
        for(int i = 0 ;i < score.length; i++){

            if(scores.size() == k){
                for(int j = 0 ;j< scores.size(); j++){
                    if(score[i] > scores.get(j) ){
                        scores.remove(0);
                        scores.add(score[i]);
                        break;
                    }
                }
            }else {
                scores.add(score[i]);
            }
            Collections.sort(scores);
            answer[i] = scores.get(0);
        }
        return answer;
    }
}