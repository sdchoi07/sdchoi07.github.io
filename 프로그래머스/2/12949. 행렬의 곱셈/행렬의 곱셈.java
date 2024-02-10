class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int k = 0 ; k < arr1.length; k++) {
            for (int i = 0; i < arr2[0].length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    answer[k][i] += (arr1[k][j] * arr2[j][i]);
                }
            }
        }
        return answer;
    }
}