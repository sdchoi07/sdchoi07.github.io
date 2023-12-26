import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static int n;
    static boolean[][] chk;
    static int babyShark = 2;
    static int[][] map;
    static int[] shark = new int[3];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    static int cnt =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

       for(int i = 0 ;i < n ; i++){
           st = new StringTokenizer(br.readLine(), " ");
           for(int j = 0 ;j < n; j++){
               map[i][j] = Integer.parseInt(st.nextToken());
               if(map[i][j] == 9){
                   shark[0] = i;
                   shark[1] = j;
                   shark[2] = 0;
                   map[i][j] = 0;
               }
           }
       }
       moving();
       System.out.println(answer);
    }
    static void moving(){
        chk = new boolean[n][n];
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] != o2[2]){
                    return  o1[2] - o2[2];
                }else if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });

        chk[shark[0]][shark[1]] = true;
        q.add(new int[] {shark[0], shark[1], shark[2]});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curM = cur[2];
            for(int i = 0 ;i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX>=0 && nextY>=0 && nextX<n && nextY<n){
                    if(!chk[nextX][nextY] && map[nextX][nextY] <= babyShark){
                        q.add(new int[]{nextX, nextY, curM+1});
                        chk[nextX][nextY] = true;
                    }
                }
            }

            eating(q);
        }

    }
    static void eating(Queue<int[]> q){
        if(!q.isEmpty()){
            int[] now =  q.peek();
            int nowX = now[0];
            int nowY = now[1];
            int nowM = now[2];

            if(map[nowX][nowY] != 0 && map[nowX][nowY] < babyShark){
                cnt++;
                if(cnt == babyShark){
                    babyShark++;
                    cnt =0;
                }
                q.clear();
                q.add(new int[]{nowX, nowY, 0});
                chk = new boolean[n][n];
                map[nowX][nowY] = 0;
                answer +=nowM;
            }
        }
    }
}
