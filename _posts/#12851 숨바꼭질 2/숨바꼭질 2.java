import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int n, k, speed;
    static int[]chk;
    static int[] answer ;
    static int cnt = 0;
    static int min = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        speed = 0;
        if (n >=k) {
            System.out.println((n - k) + "\n1");
            return;
        }
        chk = new int[100001];
        bfs(n);
        System.out.println(min + " " + cnt);
    }
    static void bfs(int start){

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        chk[start] = 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            if(min < chk[node]) return;

            for(int i = 0 ;i < 3; i++) {
                int next = 0;
                if (i == 0) {
                    next = node -1;
                }else if(i ==1){
                    next = node +1;
                }else{
                    next = node *2;
                }
                if(next < 0 || next>100000) continue;
                if(next == k){
                    min = chk[node];
                    cnt++;
                }

                if(chk[next] == 0 || chk[next] == chk[node] +1){
                    q.add(next);
                    chk[next] = chk[node] +1;
                }
            }
        }
    }

}
