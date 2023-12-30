import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ;i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int start = 0;
        int end = 0;
        int cnt = Integer.MAX_VALUE;
        int sum = arr[start];
        while(start < n && end < n){
            if(sum < s){
                end++;
                if(end<n) {
                    sum += arr[end];
                }
            }else if( sum >= s){
                cnt = Math.min(cnt, Math.abs(start-end)+1);
                if(start<n){
                    sum -=arr[start];
                }
                start ++;
            }
        }
        if(cnt == Integer.MAX_VALUE){
            System.out.print(0);
        }else{
            System.out.print(cnt);
        }
    }
}

