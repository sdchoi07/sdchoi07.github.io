import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i =1 ;i <=n;i++){
            arr[i] = i;
        }
        for(int i = 2 ;i <=sqrt(n); i++){
            for(int j= i*i;j<=n; j+=i){
                    arr[j] = 0;

            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 2 ;i <=n ; i++){
            if(arr[i] !=0){
                list.add(i);
            }
        }
        int start = 0;
        int end = 0;
        int answer = 0;
        if(n < 2){
            System.out.println(0);
            return;
        }
        while(start <= end && end<list.size()){
            int sum = 0;
            for(int i =  start; i<=end ; i++) {

                sum += list.get(i);
            }
            if(sum == n ){
                answer++;

            }
            if(n > sum){
                end++;
            }else{
                start++;

            }
        }
        System.out.println(answer);
    }
}




