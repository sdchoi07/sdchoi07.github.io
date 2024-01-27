class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
         for(int i = 0 ;i < sizes.length;i++){
            if(sizes[i][0] >  sizes[i][1]){
                int temp = 0;
                temp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] =  temp;
            }
        }
        int maxZero = 0;
        int maxOne = 0;
        for(int i = 0 ;i < sizes.length; i++){
                if(maxOne < sizes[i][0]){
                    maxOne = sizes[i][0];
                }
                if(maxZero < sizes[i][1]){
                    maxZero = sizes[i][1];
                }
            }

        answer = maxOne * maxZero;
        return answer;
    }
}