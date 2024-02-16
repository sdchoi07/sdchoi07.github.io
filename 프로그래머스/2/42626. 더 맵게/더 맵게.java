import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ;i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        while(pq.size()>1 &&  pq.peek() <K){
            int num = pq.poll();
            int sum = num + (pq.poll()*2);
            pq.add(sum);
            answer++;
        }
        if (K > pq.peek()) {
            return -1;
        }
        return answer;
    }
}