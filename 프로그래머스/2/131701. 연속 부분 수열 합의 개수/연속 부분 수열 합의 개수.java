import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
         Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    if (j + k > elements.length - 1) {
                        sum += elements[j + k - elements.length];
                    } else {
                        sum += elements[j + k];
                    }
                }
                set.add(sum);

            }
        }
        answer = set.size();
        return answer;
    }
}