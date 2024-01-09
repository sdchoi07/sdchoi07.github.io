import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    static int n, m;
    static int cnt = 0;
    static String[][] map;
    static int[][] data;
    static int[] place;
    static int[][] visit;
    static int idx =1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        visit = new int[n][m];
        data = new int[n][m];
        place = new int[2];

        for(int i= 0; i < n; i++){
            st = new StringTokenizer(br.readLine(),"");
            String a = st.nextToken();;
            for(int j = 0 ;j <a.length(); j++){
                map[i][j] = String.valueOf(a.charAt(j));
            }
        }
        int[] answer = new int[2];
        for(int i = 0 ;i < n; i++){
            for(int j = 0 ;j < m; j++){
                if(visit[i][j] == 0) {
                    dfs(i, j);
                }

            }
        }
        System.out.println(cnt);
    }
    static void dfs(int a, int b) {
        visit[a][b] = idx;

            if (map[a][b].equals("D")) {
                place[0] = a+1;
                place[1] = b;
            } else if (map[a][b].equals("R")) {
                place[0] = a;
                place[1] = b+1;
            } else if (map[a][b].equals("U")) {
                place[0] = a-1;
                place[1] = b;
            } else if(map[a][b].equals("L")){
                place[0] = a;
                place[1] = b-1;
            }
            if(visit[place[0]][place[1]] == 0){
                dfs(place[0],place[1]);
            }else {
                if (visit[place[0]][place[1]] == idx) {
                    cnt++;
                }
                idx++;
            }

    }
}