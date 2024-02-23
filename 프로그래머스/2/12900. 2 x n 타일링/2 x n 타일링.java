class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[60000];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ;i < dp.length; i++){
            dp[i] = (dp[i-1]%1000000007) + (dp[i-2]%1000000007);
            if( n == i){
                break;
            }
        }
        return answer = dp[n]%1000000007;
    }
}