import java.util.regex.Pattern;
class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        String regex = "^[\\d]*$";
        answer = Pattern.matches(regex, s);
        if(answer){
            if(s.length() != 4 && s.length() != 6){
                answer = false;
            }
        }
        return answer;
    }
}