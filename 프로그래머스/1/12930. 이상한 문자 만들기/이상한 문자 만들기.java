class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split("");
        String word = "";
        for(int i = 0 ; i<words.length;i++){
            word+=words[i];
            if(" ".equals(words[i])){

                for(int j = 0 ; j< word.length(); j++){
                    if (j % 2 == 0) {
                        answer += String.valueOf(word.charAt(j)).toUpperCase();
                    } else {
                        answer += String.valueOf(word.charAt(j)).toLowerCase();
                    }

                }

                word = "";
            }



        }
        if(!"".equals(word)){
            for(int j = 0 ; j< word.length(); j++){
                if (j % 2 == 0) {
                    answer += String.valueOf(word.charAt(j)).toUpperCase();
                } else {
                    answer += String.valueOf(word.charAt(j)).toLowerCase();
                }

            }
        }
        return answer;
    }
}