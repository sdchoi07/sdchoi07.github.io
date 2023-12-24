import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] map;
    static boolean[][][] chk;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt = 1;
    static int[] place = new int[2];
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        chk = new boolean[n][m][2];
        for(int i = 0 ;i < n ; i++){
            String str = br.readLine();
            for (int j = 0 ;j <m;j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs();
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }
    }
    static void bfs() {

        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] {0,0,1,0});
        chk[0][0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curVal = cur[2];
            int visit = cur[3];
            if (curX == n - 1 && curY == m - 1) {
                answer = curVal;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (!chk[nextX][nextY][visit] && map[nextX][nextY] == 0) {
                        q.add(new int[]{nextX, nextY, curVal+1, visit});
                        chk[nextX][nextY][visit] = true;
                    }else {
                        if (visit == 0 && !chk[nextX][nextY][visit + 1]) {
                            chk[nextX][nextY][visit + 1] = true;
                            q.add(new int[]{nextX, nextY, curVal + 1, visit + 1});
                        }
                    }

                }
            }
        }

    }
}
