import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 class Bus {
    int start,end,cost;



    public Bus(int start, int end, int cost){
        this.start=start;
        this.end = end;
        this.cost = cost;
    }
}
public class Main {

    static int n, m, x;
    static long[] dist;
    static Bus[] bus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dist = new long[n+1];
        bus = new Bus[m];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            bus[i] = new Bus(from, to, time);
        }
        for (int i = 0; i < n - 1; i++) {
            for(int j = 0 ;j < m; j++){
                Bus b = bus[j];
                int from = b.start;
                int to = b.end;
                int cost = b.cost;
                if(dist[from] != Integer.MAX_VALUE && dist[to] > dist[from] + cost){
                    dist[to] = dist[from] + cost;
                }
            }
        }
        boolean chk = false;
        for(int j = 0 ;j < m; j++){
            Bus b = bus[j];
            int from = b.start;
            int to = b.end;
            int cost = b.cost;
            if(dist[from] != Integer.MAX_VALUE && dist[to] > dist[from] + cost){
               chk = true;
               break;
            }
        }
        if(!chk){
            for(int i = 2; i<n+1; i++){
                if(dist[i] != Integer.MAX_VALUE){
                    System.out.println(dist[i]);
                }else{
                    System.out.println(-1);
                }
            }
        }else {
            System.out.println(-1);
        }
    }

}
