import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String[] str1 = br.readLine().split(" ");
        int[] bytes = new int[n];
        for(int i = 0 ;i < n; i++){
            bytes[i] = Integer.parseInt(str1[i]);
        }
        String[] str2 = br.readLine().split(" ");
        int[] cost = new int[n];
        int sum = 0;
        for(int i = 0 ;i<n; i++){
            cost[i] = Integer.parseInt(str2[i]);
            sum+=cost[i];
        }

        int[] dp = new int[sum+1];
        int min = Integer.MAX_VALUE;
        for(int i = 0 ;i < n; i++){
            for(int j = sum; j>=cost[i]; j--){
                    dp[j] = Math.max(dp[j],dp[j-cost[i]]+bytes[i]);
            }
        }
        for(int i=0; i<=sum; i++) {
            if(dp[i]>=m) {
                System.out.println(i);
                break;
            }
        }
    }

}