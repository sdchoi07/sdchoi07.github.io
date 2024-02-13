import java.util.*;
class Solution {
    static int max = 0;
    static boolean[] chk;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {

        chk = new boolean[dungeons.length];
        System.out.println(Arrays.deepToString(dungeons));
        for(int i = 0; i < dungeons.length; i++) {
            int[] dun = dungeons[i];
            int idx = dun[0];
            int spend =dun[1];
            if(!chk[i]) {
                if (k >= idx) {
                    k = k - spend;
                    answer++;
                    chk[i] = true;
                }
            }
             dfs(i,k, dungeons);
            chk[i] = false;
            answer--;
            k= k+spend;

        }
        return max;
    }
    void dfs(int j,int k, int[][] dungeons){
        for(int i = 0;i < dungeons.length; i++){

            int[] dun = dungeons[i];
            int idx = dun[0];
            int spend =dun[1];
            if(!chk[i]) {
                if (k >= idx) {
                    k = k - spend;
                    answer++;
                    chk[i] = true;
                    dfs(i+1, k, dungeons);
                    chk[i] = false;
                    k = k+spend;
                    answer--;

                }
            }
        }
        if (answer > max) {
            max = answer;
        }
    }
}