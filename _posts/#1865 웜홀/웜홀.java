import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 class Bus{
     int  end, value;
             public Bus(int end, int value){
                this.end = end;
                this.value = value;
             }
 }
public class Main {

    static int t;
    static long[] dist;
    static ArrayList<Bus>[] bus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        t = Integer.parseInt(st.nextToken());

        for(int i = 0 ;i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            bus = new ArrayList[n+1];
            for(int j = 0 ;j < n+1; j++){
                bus[j] = new ArrayList<>();
            }
            dist = new long[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE/4);
            dist[1] = 0;

            for(int j = 0 ; j< m; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                bus[start].add(new Bus(end, value));
                bus[end].add(new Bus(start, value));

            }
            for(int j = 0; j < w; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                bus[start].add(new Bus(end, -value));
            }

            for(int k = 0 ; k<n-1;k++){
                for(int j = 1 ;j < bus.length; j++){
                    for(int c = 0; c<bus[j].size(); c++) {
                        Bus next = bus[j].get(c);
                        int nextNode = next.end;
                        int nextValue = next.value;
                        if (dist[nextNode]> nextValue + dist[j]){
                            dist[nextNode] = nextValue + dist[j];
                        }
                    }
                }
            }
            boolean chk = false;
            for(int j = 1 ; j<bus.length; j++){
                for(int c= 0; c<bus[j].size(); c++){
                    Bus next = bus[j].get(c);
                    int nextNode = next.end;
                    int nextValue =next.value;
                    if(dist[nextNode] > nextValue + dist[j]){
                        chk = true;
                        break;
                    }
                }
            }
            if(!chk){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }

        }
    }

}
