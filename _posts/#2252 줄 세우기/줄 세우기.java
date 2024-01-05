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
    static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        indegree = new int[n+1];
        list = new ArrayList[n+1];
        for(int i = 1; i<=n;i++){

            list[i] = new ArrayList<Integer>();
        }
        for(int i = 1 ;i <= m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            indegree[b]++;

        }
        line();
    }
    static void line(){
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1;i <=n ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();

            System.out.print(cur+" ");

            for(int i = 0 ;i < list[cur].size(); i++){
                int next = list[cur].get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }
    }
}




