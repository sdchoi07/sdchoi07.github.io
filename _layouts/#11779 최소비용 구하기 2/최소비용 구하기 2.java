import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,m;
    static ArrayList<int[]>[] list;
    static boolean[]chk;
    static int answer = Integer.MAX_VALUE;
    static int[] values ;
    static int[] preCity;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];

        for(int i = 1 ; i <= n; i++) {
            list[i] = new ArrayList<int[]>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[start].add(new int[]{end,value});
        }

        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

            dij(start, end);
            Stack<Integer> stack = new Stack<Integer>();
            int cnt = 1;
            System.out.println(values[end]);
            stack.push(end);
            while(preCity[end] != 0){
                cnt++;
                stack.push(preCity[end]);
                end = preCity[end];
            }

            System.out.println(cnt);
            while(!stack.isEmpty()){
                System.out.print(stack.pop() + " ");
            };

    }
    static void dij(int start, int end){
        chk = new boolean[n+1];
        values = new int[n+1];
        preCity = new int[n+1];
        Arrays.fill(values, Integer.MAX_VALUE);
        values[start] = 0;
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]- o2[1];
            }
        });

        q.add(new int[]{start,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curCity = cur[0];
            int curValue = cur[1];
            if(chk[curCity]){
                continue;
            }
            chk[curCity] = true;
            for(int i = 0 ;i < list[curCity].size(); i++){
                int[] next = list[curCity].get(i);
                int nextCity = next[0];
                int nextValue = next[1];
                if( values[nextCity] > curValue + nextValue){
                    values[nextCity] = curValue + nextValue;
                    q.add(new int[]{nextCity, values[nextCity]});
                    preCity[nextCity] = curCity;
                }

            }
        }
    }
}
