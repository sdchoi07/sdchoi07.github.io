import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    static int[][] map;
    static int[][] rgb;
    static boolean end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n+1][3];
        rgb = new int[n+1][3];
        for(int i = 1 ;i <= n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ;j< 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        int min = Integer.MAX_VALUE/4;
        for(int i = 0; i< 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    rgb[1][j] = map[1][j];
                } else {
                    rgb[1][j] = Integer.MAX_VALUE/4;
                }

            }

            for (int k = 2; k <= n; k++) {
                    rgb[k][0] = Math.min(rgb[k - 1][1], rgb[k - 1][2]) + map[k][0];
                    rgb[k][1] = Math.min(rgb[k - 1][0], rgb[k - 1][2]) + map[k][1];
                    rgb[k][2] = Math.min(rgb[k - 1][0], rgb[k - 1][1]) + map[k][2];

                }

                for (int k = 0;  k< 3; k++) {
                    if (k != i && min > rgb[n][k]) {
                        min = rgb[n][k];
                    }
                }

        }
        System.out.println(min);
    }
}



