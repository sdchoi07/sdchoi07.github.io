import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0 ;i < phone_book.length-1;i++) {
            String prefix = phone_book[i];
                String num = phone_book[i+1];
                if (num.startsWith(prefix)) {
                    answer = false;
                    break;
                }
            }

        return answer;
    }
}