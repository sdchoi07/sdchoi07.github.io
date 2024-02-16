import java.util.*;
class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static int num =1;
    static String temp = "";
    static boolean[] chk;
    public int solution(String word) {
        int answer = 0;
        chk = new boolean[word.length()];
        String[] arr = {"A","E","I","O","U"};
        dfs(arr);
        answer = map.get(word);
        return answer;
    }
    void dfs (String[] arr){

        if(temp.length() == arr.length){

            return;
        }
        for(int i = 0 ;i < arr.length; i++){
            temp += arr[i];
                map.put(temp, num++);
                dfs(arr);
                temp = temp.substring(0,temp.length()-1);
        }
    }
}