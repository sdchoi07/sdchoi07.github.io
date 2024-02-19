class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String toBi = "";
        for(int i = 0 ;i < t*m; i++){
            toBi +=Integer.toString(i,n).toUpperCase();
        }
        for(int i = 0 ; i<toBi.length();i++){
            if(i%m == p-1){
                answer+=String.valueOf(toBi.charAt(i));
            }
            if(answer.length() == t){
                break;
            }
        }
        return answer;
    }
}