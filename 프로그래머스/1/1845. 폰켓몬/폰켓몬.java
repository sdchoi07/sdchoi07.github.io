import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length/2;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ;i < nums.length;i++){
            set.add(nums[i]);
            if(max == set.size()){
                break;
            }
        }
        answer = set.size();
        return answer;
    }
}