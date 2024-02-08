import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ;i < tangerine.length;i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
        int[][] a = new int[10000001][2];
        for(int i : map.keySet()){
            a[i][0] = i;
            a[i][1] = map.get(i);
            int[] b = {a[i][0], a[i][1]};
            pq.add(b);
        }
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curIdx = cur[0];
            int curValue = cur[1];
            if(k <= 0){
                break;
            }
            answer++;
            k = k - curValue;
        }
        return answer;
    }
}