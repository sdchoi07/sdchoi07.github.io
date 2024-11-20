import java.math.BigDecimal;
class Solution {
    public double solution(int balls, int share) { 
        double answer = 1;

        for(int i = 0; i < share; i++){
            answer = answer * (balls - i) / (i+1);
        }        
        return answer;
    }
}