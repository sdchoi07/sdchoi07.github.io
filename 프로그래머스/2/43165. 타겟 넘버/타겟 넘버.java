class Solution {
    static boolean[] chk;

    static int answer = 0;
    public int solution(int[] numbers, int target) {
        int sum = 0;
        chk = new boolean[numbers.length];
       dfs(numbers, target, 0, 0);
        return answer;
    }
    void dfs(int[] numbers, int target, int sum, int s){

        if(numbers.length == s){
            if(target== sum) {
                answer++;
                return;
            }
            return;
        }

            int num = numbers[s];
                dfs(numbers, target, sum + num , s+1);
                dfs(numbers, target, sum + (num)*-1, s+1);

    }
}