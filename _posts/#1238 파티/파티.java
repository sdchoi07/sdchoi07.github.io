import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, x;
    static ArrayList<int[]>[] golist;
    static int[] houses;
    static ArrayList<int[]>[] backlist;
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            golist = new ArrayList[n+1];
            backlist = new ArrayList[n+1];
            for(int i = 1 ;i < golist.length; i++) {
                golist[i] = new ArrayList<int[]>();
                backlist[i] = new ArrayList<int[]>();
            }
        for(int i = 0 ;i < m; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                golist[a].add(new int[]{b,c});
                backlist[b].add(new int[]{a,c});
            }


           int[] goDist = recursive(golist,x);
           int[] backDist = recursive(backlist,x);
           int max = Integer.MIN_VALUE;
           int answer =0;
        for(int i = 1 ;i <= n; i++){
             int result = goDist[i] + backDist[i];
             if( max < result) {
                 max = result;
                 answer = max;
             }
        }
        System.out.println(answer);
    }




    static int[] recursive(ArrayList<int[]>[] list , int x){

        boolean[] chk = new boolean[m+1];
        houses = new int[n+1];
        Arrays.fill(houses, Integer.MAX_VALUE);

        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        q.offer(new int[]{x,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int nowNode = cur[0];
            int nowDist = cur[1];
            if(chk[nowNode]){
                continue;
            }
            chk[nowNode] = true;

            for(int i = 0; i<list[nowNode].size(); i++){
                int[] next = list[nowNode].get(i);
                int nextNode = next[0];
                int nextDist = next[1];
                if( houses[nextNode]> nowDist + nextDist && !chk[nextNode]){
                    houses[nextNode] = nowDist + nextDist;
                    q.add(new int[]{nextNode, houses[nextNode]});
                }
            }

        }
        return houses;
    }


}
