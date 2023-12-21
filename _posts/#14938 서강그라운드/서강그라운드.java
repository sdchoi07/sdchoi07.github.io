import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, r;
    static ArrayList<int[]>[] list;
    static int[] items;
    static Queue<int[]> q = new LinkedList<int[]>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        items = new int[n+1];

        list = new ArrayList[n+1];
        for(int i = 0 ;i <=n; i++){
            list[i] = new ArrayList<int []>();
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1 ;i <= n; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i <r; i++){
            st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b,dist});
            list[b].add(new int[]{a,dist});

        }
        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <=n;i++) {
            answer = Math.max(dfs(i), answer);
        }
        System.out.println(answer);
    }

    static int dfs(int start){
        boolean[] visited = new boolean[n+1];
        int result = 0;
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        q.add(new int[]{start,0});
        while(!q.isEmpty()){

            int[] now = q.poll();
            int node = now[0];
            if(visited[node]){
                continue;
            }
            visited[node] = true;
            result +=items[node];
                for(int i = 0; i<list[node].size(); i++){
                    int[] next = list[node].get(i);
                    int nextNode = next[0];
                    int nextValue = next[1];
                    if(nextValue + now[1] <= m && !visited[nextNode]){
                        q.add(new int[]{nextNode, nextValue +now[1]});
                    }
            }
        }
        return result;
    }
}
