import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    static int n,m;
    static ArrayList<Integer>[] list;
    static int[] indegreed;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i = 0 ;i < list.length; i++){
            list[i] = new ArrayList<>();
        }
        indegreed = new int[n+1];
        for(int i = 0 ;i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            indegreed[b]++;
        }

        start();
    }
    static void start(){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 1 ;i < indegreed.length;i++){
            if(indegreed[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur + " ");
            for(int i = 0 ;i < list[cur].size(); i++){
                int next = list[cur].get(i);
                indegreed[next]--;
                if(indegreed[next] ==0 ){
                    q.add(next);
                }

            }
        }
    }
}