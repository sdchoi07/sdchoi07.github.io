class Solution {
    public int solution(int n) {
        int answer = 0;
        String ch = Integer.toString(n, 3);
        String reverse = "";
        for(int i = ch.length()-1; i>=0; i--){
            reverse+=String.valueOf(ch.charAt(i));
        }
        answer = Integer.parseInt(reverse, 3);
        return answer;
    }
}