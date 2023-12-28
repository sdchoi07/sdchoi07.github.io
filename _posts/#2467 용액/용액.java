import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long[] arr = new long[n];
        for(int i = 0 ;i < n; i++){
           arr[i] = Long.parseLong(st.nextToken());

        }
        int startIndex = 0;
        int endIndex = n-1;
        int left = 0;
        int right = 0;
        long min = Long.MAX_VALUE;
        while(startIndex < endIndex){
            long sum = arr[startIndex] + arr[endIndex];
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                left = startIndex;
                right = endIndex;
            }
            if(sum <0){
                startIndex++;
            }else{
                endIndex--;
            }

        }
        System.out.println(arr[left] + " "+ arr[right]);



    }
}

