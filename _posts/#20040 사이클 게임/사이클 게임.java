import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i = 0 ;i < n; i++){
            arr[i] = i;
        }
        boolean chk = false;
        for(int i = 0 ;i < m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) == find(b)){

                System.out.println(i+1);
                return;
            }else{
                union(a,b);
            }
        }

            System.out.println(0);


    }
    static int find(int x){
        if(arr[x] == x){
            return x;
        }else {
            return arr[x] = find(arr[x]);
        }
    }
    static void union(int x, int y){
         int a = find(x);
         int b = find(y);
         if(a == b){
             return;
         }else {
             arr[b] = a;
         }
    }
}




