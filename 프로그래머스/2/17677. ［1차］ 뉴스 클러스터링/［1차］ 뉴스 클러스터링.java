import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        int value = 0;
        Map<String, Integer> map1 = new HashMap<>();
        for(int i = 0; i < str1.length()-1;i++){
            String temp = str1.substring(i,i+2);
            temp = temp.replaceAll("[^a-z]","");
            if(temp.length() == 1 || temp.length() == 0){
                continue;
            }
            map1.put(temp, map1.getOrDefault(temp,0)+1);
        }

        for(String key : map1.keySet()){
            value+=map1.get(key);
        }


        str2 = str2.toLowerCase();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i = 0 ;i < str2.length()-1; i++){
            String temp = str2.substring(i,i+2);
            temp = temp.replaceAll("[^a-z]","");
            if(temp.length() == 1 || temp.length() == 0){
                continue;
            }
            map2.put(temp, map2.getOrDefault(temp,0)+1);
        }

        for(String key : map2.keySet()){
            value+=map2.get(key);
        }
        System.out.println(map2);
        if(map1.isEmpty() &&  map2.isEmpty()){
            return 65536;
        }
        double union = 0;
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                int val = map2.get(key);
                if(val > 0){
                    union+=Math.min(map1.get(key),map2.get(key));
                }
            }
        }
        double simi = union/(value-union);

        answer = (int)(simi*65536);
        return answer;
    }
}