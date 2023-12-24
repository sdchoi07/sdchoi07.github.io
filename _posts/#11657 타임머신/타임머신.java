import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 class Bus{
     int start, end, value;
             public Bus(int start, int end, int value){
                this.start = start;
                this.end = end;
                this.value = value;
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
        bus = new Bus[m];
        dist = new long[n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[1] =  0;
        for(int i = 0 ;i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            bus[i]  = new Bus(start, end, value);
        }

        for(int i = 0 ;i < n-1; i++) {
            for (int j = 0; j < m; j++) {
                Bus b = bus[j];
                int curStart = b.start;
                int curEnd = b.end;
                int curValue = b.value;
                if (dist[curStart] != Integer.MAX_VALUE && dist[curEnd] > dist[curStart] + curValue) {
                    dist[curEnd] = dist[curStart] + curValue;
                }
            }
        }
            boolean update = false;
            for(int j = 0 ;j < m; j++){
                Bus b = bus[j];
                int curStart = b.start;
                int curEnd = b.end;
                int curValue = b.value;
                if(dist[curStart] != Integer.MAX_VALUE && dist[curEnd] > dist[curStart] +  curValue){
                    update = true;
                    break;
                }
            }
            if(!update){
                for(int i = 2; i <=n;i++){
                    if(dist[i] != Integer.MAX_VALUE){
                        System.out.println(dist[i]);
                    }else{
                        System.out.println(-1);
                    }
                }
            }else{
                System.out.println(-1);
            }
    }

}
