import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        long[] arr = new long[n];
        long[] answer = new long[3];
        for(int i = 0 ;i < n; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        long sum = 0;
        long min = Long.MAX_VALUE;
        for(int i = 0; i <n-2; i++) {
            int index = i;
            int start = i+1;
            int end = arr.length -1;
            while (start < end) {
                sum = arr[start] + arr[end] + arr[index];
                if( min > Math.abs(sum)){
                    min = Math.abs(sum);
                    answer[0] = arr[start];
                    answer[1] = arr[end];
                    answer[2] = arr[index];
                }
                if (0 < sum) {
                    end--;
                } else if (0 >= sum) {
                    start++;
                }
            }
        }
        Arrays.sort(answer);
        for(int i = 0 ;i < 3; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
