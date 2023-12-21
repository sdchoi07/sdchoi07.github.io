import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] cost = new int[n+1][n+1];
        for(int i = 1 ;i <=n; i++){
            for(int j = 1 ;j <=n; j++){
                cost[i][j] = Integer.MAX_VALUE/4;
            }
            cost[i][i]= 0;
        }
        for(int i = 0 ;i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(cost[a][b] > c){
                cost[a][b] = c;
            }
        }

        for(int i = 1 ;i <=n; i++){
            for(int j = 1 ;j<=n; j++){
                for(int k = 1 ;k <= n; k++){
                    if(cost[j][k] > cost[j][i] + cost[i][k]){
                        cost[j][k] = cost[j][i] + cost[i][k];

                    }
                }
            }
        }
        for(int i = 1 ;i <= n; i++){
            for(int j =1; j<=n;j++){
                if(cost[i][j] != Integer.MAX_VALUE/4){
                    System.out.print(cost[i][j] + " ");
                }else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
}