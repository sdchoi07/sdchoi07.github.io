class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0 ;i < nums.length;i++){
            for(int j = i+1;j <nums.length;j++){
                int sum = 0 ;
                for(int k = j+1; k<nums.length;k++){
                    sum = nums[i]+nums[j]+nums[k];
                    int cnt = 0 ;
                    for(int p = 3; p<=sum; p++){
                        if(sum%p == 0)cnt++;
                    }
                    if(cnt == 1){
                        answer++;
                        cnt=0;
                    }
                }
            }
        }

        return answer;
    }
}