import java.util.*;
class Solution {
   public String solution(int[] numbers) {
        String answer = "";

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        for(int i = 0 ;i < numbers.length;i++){
            pq.add(String.valueOf(numbers[i]));
        }
        while(!pq.isEmpty()){
            answer+=String.valueOf(pq.poll());
        }
       if(answer.charAt(0) == '0' ){
            answer = "0";
        }
        return answer;
    }
}