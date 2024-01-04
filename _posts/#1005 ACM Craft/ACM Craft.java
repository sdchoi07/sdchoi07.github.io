import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;
class Building{
    int  end;

        public Building( int end){

            this.end = end;
    }
}
public class Main {
    static ArrayList<Building>[] list;
    static boolean[]chk;
    static int[] records;
    static int[] times;
    static int[] indegree;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int t = Integer.parseInt(st.nextToken());

        for(int i = 0 ;i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            list = new ArrayList[n+1];


            String[] arr = br.readLine().split(" ");
            times = new int[n+1];
            records = new int[n+1];
            for(int k = 1 ;k <=n; k++){
                times[k] = Integer.parseInt(arr[k-1]);
                records[k] = Integer.parseInt(arr[k-1]);
            }
            for(int j = 0 ;j < n+1; j++) {
                list[j] = new ArrayList<Building>();
            }
            indegree = new int[n+1];

            for(int j = 1 ;j <=m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list[start].add(new Building(end));
                indegree[end]++;
            }

            st = new StringTokenizer(br.readLine()," ");
            int goal = Integer.parseInt(st.nextToken());
             play(goal);

        }

    }
    static void play(int goal){

        Queue<Building> q = new LinkedList<>();
        for(int i = 1; i<=n;i++){
            if(indegree[i] == 0){
                q.offer(new Building(i));
            }
        }
        while(!q.isEmpty()){
            Building cur = q.poll();
            int curEnd = cur.end;





            for(int i = 0 ;i < list[curEnd].size(); i++){
                Building next = list[curEnd].get(i);
                int nextBuild = next.end;
                int nextTime = records[curEnd] + times[nextBuild];
                records[nextBuild] = Math.max(nextTime,records[nextBuild]);
                indegree[nextBuild]--;
                if(indegree[nextBuild] == 0) {
                    q.offer(new Building(nextBuild));
                }

            }
        }
        System.out.println(records[goal]);
    }
}




