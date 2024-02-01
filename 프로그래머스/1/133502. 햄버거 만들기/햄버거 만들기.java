class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder build = new StringBuilder();

        for(int i=0; i<ingredient.length; i++) {
            build.append(ingredient[i]);
            if(build.length()>3 && build.subSequence(build.length()-4, build.length()).equals("1231")) {
                answer++;
                build.delete(build.length()-4, build.length());
            }
        }
        return answer;
    }
}