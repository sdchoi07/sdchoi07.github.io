import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m ,cnt,answer;
    static int[][] map;
    static int[][] comp;
    static boolean[][] chk;
    static int min = 0;
    static int[] x = {1,0,-1,0};
    static int[] y = {0,1,0,-1};
    static Queue<int[]> q = new LinkedList<int[]>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cnt = 0;
        map = new int[n][m];

        chk = new boolean[n][m];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ;j<m;j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        bfs(0,0);
        System.out.println(answer);
    }
    static void bfs(int start, int end){
        comp = new int[n][m];
        if(cnt == 3){

            int sum = 0;
            sendToComp();
            while(!q.isEmpty()){
                int[] qOut = q.poll();

                for(int i = 0 ;i < 4; i++){
                    int dx = qOut[0] + x[i];
                    int dy = qOut[1] + y[i];
                    if(dx >=0 && dx< n && dy>=0 && dy <m){
                        if(comp[dx][dy] == 0){
                            comp[dx][dy] = 2;
                            q.add(new int[]{dx,dy});
                        }
                    }
                }
            }
            for(int i = 0 ;i < n; i++){
                for(int j = 0 ;j <m; j++){
                    if(comp[i][j] == 0){
                        sum++;
                    }
                }
            }
            min = Math.max(min, sum);
            return;
        }
        for(int i = 0 ;i <n;i++){
            for(int j = 0 ;j < m; j++){
                if(map[i][j] ==0){
                    map[i][j] = 1;
                    cnt++;
                    bfs(i,j);
                    cnt--;
                    map[i][j] =0;
                }
            }
        }
         answer = min;


    }

    static void sendToComp(){
        for(int i = 0 ;i < n; i++){
            for(int j = 0 ;j < m; j++){
                if(map[i][j] == 2){
                    q.add(new int[]{i,j});
                    comp[i][j] = map[i][j];
                }
                else if(map[i][j] == 1){
                    comp[i][j] = map[i][j];
                }
            }
        }
    }
}

