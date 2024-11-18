import java.math.BigDecimal;class Solution {
    public String solution(String a, String b) {
        String answer = "";
         BigDecimal bd1 = new BigDecimal(a);
        BigDecimal bd2 = new BigDecimal(b);
        answer = String.valueOf(bd1.add(bd2));
        return answer;
    }
}