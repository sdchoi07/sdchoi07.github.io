import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] scores = {3,2,1,0,1,2,3};
        Map<String, Integer> map = new HashMap<>();
        map.put("R",0); map.put("T",0);
        map.put("C",0); map.put("F",0);
        map.put("J",0); map.put("M",0);
        map.put("A",0); map.put("N",0);

        for(int i = 0 ;i< survey.length; i++){
            String person = survey[i];
            String a = String.valueOf(person.charAt(0));
            String b = String.valueOf(person.charAt(1));
                int num = choices[i]-1;
                int score = scores[num];
                if(num < 3){
                    map.put(a, map.get(a)+score);
                }else if(num > 3){
                    map.put(b, map.get(b)+score);
                }

        }
        answer +=map.get("R") >= map.get("T") ? "R" : "T";
        answer +=map.get("C") >= map.get("F") ? "C" : "F";
        answer +=map.get("J") >= map.get("M") ? "J" : "M";
        answer +=map.get("A") >= map.get("N") ? "A" : "N";
        return answer;

    }
}