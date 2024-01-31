import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character,Integer> move = new HashMap<>();

        for(String key:keymap){

            for(int i=0;i<key.length();i++){

                char sign = key.charAt(i);

                int step=move.getOrDefault(sign,i+1);

                move.put(sign,Math.min(step,i+1));
            }
        }

        for(int i=0;i<targets.length;i++){
            for(int j=0;j<targets[i].length();j++){
                char t = targets[i].charAt(j);

                if(move.containsKey(t)){
                    answer[i]+=move.get(t);
                }else{
                    answer[i]=-1;
                    break;
                }


            }
        }

        return answer;
    }
}