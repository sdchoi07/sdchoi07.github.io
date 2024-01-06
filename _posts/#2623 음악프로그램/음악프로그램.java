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
    static int[] answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i = 1; i < list.length; i++){
            list[i] = new ArrayList<>();
        }
        indegree = new int[n+1];
        answer = new int[n];
        for(int i = 0 ;i < m; i ++){
            String[] str = br.readLine().split(" ");
            int pd = Integer.parseInt(str[0]);
            for(int j = 1 ;j<pd; j++) {
                int a = Integer.parseInt(str[j]);
                int b = Integer.parseInt(str[j+1]);
                list[a].add(b);
                indegree[b]++;
            }
        }
        ordering();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] != 0 ){
                System.out.println(0);
                return;
            }
        }
        for(int i = 0 ;i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
    static void ordering(){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ;i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int k =0;
        while(!q.isEmpty()){
            int cur = q.poll();

            answer[k++] = cur;


            for(int i = 0 ;i < list[cur].size(); i++){
                int next = list[cur].get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
    }
}