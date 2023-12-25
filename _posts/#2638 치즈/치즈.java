import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] map;
    static int[][] temp;
    static boolean[][] chk;
    static int answer = Integer.MAX_VALUE;
    static Queue<int[]> q = new LinkedList<int[]>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int time = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ;j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        block();

        System.out.println(time);
    }
    static void bfs(){
        temp = new int[n][m];
        for(int i = 0 ;i < n; i++){
            for(int j=0 ; j<m; j++){
                temp[i][j] = map[i][j];
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int cnt = 0;
            for(int i = 0 ;i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m){
                    if(temp[nextX][nextY] ==2) {
                        cnt++;

                    }
                    if(cnt == 2){
                        map[curX][curY] = 0;
                        break;
                    }
                }
            }
        }

        time++;
        block();
    }
    static void cheese(){


        for(int i = 0 ;i < n; i++){
            for(int j= 0 ;j < m; j++){
                if(map[i][j] == 1){

                    q.add(new int[]{i,j});
                }
            }
        }
        if(!q.isEmpty()){
            bfs();
        }else{
            
            return;
        }
    }

    static void block(){
        q.add(new int[]{0,0});
        chk = new boolean[n][m];
        map[0][0] = 2;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int count = 0;
            for(int i = 0 ;i < 4; i++){
                    int nextX = curX + dx[i];
                    int nextY = curY + dy[i];
                    if( nextX>=0 && nextX <n && nextY>=0 && nextY <m){
                        if(!chk[nextX][nextY] && map[nextX][nextY] != 1){
                            q.add(new int[]{nextX, nextY});
                            map[nextX][nextY] = 2;
                            chk[nextX][nextY] = true;
                        }

                }
            }
        }
        cheese();
    }
}
