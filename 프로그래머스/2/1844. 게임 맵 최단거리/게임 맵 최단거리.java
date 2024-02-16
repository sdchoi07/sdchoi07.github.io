import java.util.*;
class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public int solution(int[][] maps) {
        int answer = 0;
        dfs(maps);
        answer = maps[maps.length-1][maps[0].length-1];
        if(answer == 0 || answer == 1){
            answer= -1;
        }
        return answer;
    }
    void dfs(int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()) {
            int[] qOut = q.poll();
            int qx= qOut[0];
            int qy= qOut[1];
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + qx;
                int y = dy[i] + qy;
                if(x>=0 && y>=0 && x< maps.length && y<maps[0].length){
                    if(maps[x][y] == 1){
                        maps[x][y] = maps[qx][qy] + 1;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
    }
}