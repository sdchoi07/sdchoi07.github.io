import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    static int n,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0 ;i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer[0] = arr[0];
        int idx = 1;
        for(int i = 1; i <n; i++){
            int key = arr[i];

            if(answer[idx - 1] <key){
                idx++;
                answer[idx -1] = key;
            }else{
                int left = 0;
                int right = idx;
                while(left<right){
                    int mid = (left+right)/2;

                    if(answer[mid] < key){
                        left = mid+1;
                    }else{
                        right = mid;
                    }
                }
                answer[left] = key;
            }

        }
        System.out.println(idx);
    }
}