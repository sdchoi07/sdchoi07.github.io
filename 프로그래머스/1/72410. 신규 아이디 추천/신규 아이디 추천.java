import java.util.*;
class Solution{
    public String solution(String new_id) {
        String answer = "";

        String word = new_id.toLowerCase();

        word = word.replaceAll("[^a-z0-9-_.]","");

        word =word.replaceAll("\\.{2,}", ".");

        if(word.charAt(0) == '.'){
            word = word.substring(1, word.length());
        }
        if(word.equals("")){
            return answer = "aaa";
        }
        if(word.charAt(word.length()-1) == '.'){
            word = word.substring(0, word.length()-1);
        }



        if(word.length()>15){
            word = word.substring(0,15);
        }
        word = word.replaceAll("[.]$","");

        if(word.length() < 3){
            String a ="";
            a= String.valueOf(word.charAt(word.length()-1));
            while(word.length() < 3){
                word+=a;
            }
        }
        System.out.println(word);
        return answer = word;
    }
}