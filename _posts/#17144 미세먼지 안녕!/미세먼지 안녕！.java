import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r, c, t;
    static int[][] dusts;
    static int[] x = {1,0,-1,0};
    static int[] y = {0,1,0,-1};
    static Queue<int[]> q = new LinkedList<int[]>();
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            dusts = new int[r][c];
            for(int i = 0 ;i < r; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j= 0 ; j<c; j++){
                    dusts[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        for(int k= 0 ; k <t ; k++) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (dusts[i][j] != 0 && dusts[i][j] != -1) {
                        q.offer(new int[]{i,j,dusts[i][j]});
                    }
                }
            }
            spreadDust();
            boolean chk = true;
            for(int i = 0 ;i < r; i++){
                for(int j = 0 ;j < c;j++){
                    if(chk && dusts[i][j] == -1) {
                        clear(i, j, chk);
                        chk = false;
                    }
                    else if(!chk && dusts[i][j] == -1){
                        clear(i,j,chk);
                    }
                }
            }
        }
        int sum = 0;
        for(int i = 0 ;i < r; i++){
            for(int j = 0 ;j<c;j++){
                if(dusts[i][j] != -1){
                    sum+=dusts[i][j];
                }
            }
        }
        System.out.println(sum);

    }
    static void spreadDust(){

        while (!q.isEmpty()) {
            int[] qOut = q.poll();
            int nowX = qOut[0];
            int nowY = qOut[1];
            int nowDust = qOut[2];
            int cnt =0;
            int sum = 0;
            if(dusts[nowX][nowY] <5) continue;
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + x[i];
                int nextY = nowY + y[i];
                if (nextX >= 0 && nextX < r && nextY >= 0 && nextY < c) {
                    if (dusts[nextX][nextY] != -1 ) {
                        cnt++;
                        dusts[nextX][nextY] += nowDust/ 5;

                    }
                }
            }
            dusts[nowX][nowY] -= (nowDust / 5) * cnt;
        }
    }
    static void clear(int curX, int curY, boolean chk){
        if(chk){
            for(int i = curX-1; i >0; i-- ){
                    dusts[i][curY] =dusts[i-1][curY];
            }

            for(int i = curY; i <c-1; i++){
                    dusts[0][i] = dusts[0][i+1];
            }
            for(int i = 0 ; i <curX; i++){
                    dusts[i][c-1] = dusts[i+1][c-1];
            }
            for(int i = c-1; i>curY+1;  i--){
                    dusts[curX][i] = dusts[curX][i-1];
            }
            dusts[curX][1] = 0;
        }
        else if(!chk){
            for(int i = curX+1; i <r-1; i++ ){
                    dusts[i][curY] =dusts[i+1][curY];
            }

            for(int i = curY; i <c-1; i++){
                    dusts[r-1][i] = dusts[r-1][i+1];


            }
            for(int i = r-1 ; i >curX; i--){
                    dusts[i][c-1] = dusts[i-1][c-1];

            }
            for(int i = c-1; i>curY+1;  i--){
                    dusts[curX][i] = dusts[curX][i-1];
            }
            dusts[curX][1] = 0;
        }
    }
}
