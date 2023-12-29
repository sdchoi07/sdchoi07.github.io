import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
class Tree{
    int start, end, value;
           public Tree(int start, int end, int value){
                this.start = start;
                this.end = end;
                this.value = value;
            }

}
public class Main {
    static int[] vliages1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Queue<Tree>  q = new PriorityQueue<>(new Comparator<Tree>() {
            @Override
            public int compare(Tree o1, Tree o2) {
                return o1.value - o2.value;
            }
        });

        for(int i = 1 ;i <e+1 ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            q.add(new Tree(start, end, value));
        }
        vliages1 = new int[v+1];
        for(int i = 1; i<v+1; i++){
            vliages1[i] = i;
        }


        int answer = 0;
        int cost= 0;

            while (!q.isEmpty()) {
                Tree t = q.poll();
                int start = t.start;
                int end = t.end;
                int value = t.value;

                if (find(start) != find(end)) {
                    answer += value;
                    union(start, end);
                    cost = value;
                }

            }

        System.out.println(answer - cost);
    }

    static void union(int start, int end){
        int a = find(start);
        int b = find(end);
        if(a !=b){
            vliages1[b] = a;
        }
    }
    static int find(int n){
        if(n==vliages1[n]){
            return n;
        }else{
            vliages1[n] = find(vliages1[n]);
            return vliages1[n];
        }
    }
}

