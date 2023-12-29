import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static int[] nodes;

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

        nodes = new int[v+1];

        for(int i = 1; i<v+1; i++){
            nodes[i] = i;
        }


        int answer = 0;
        int edge= 0;
        while(edge < v-1){
            Tree t = q.poll();
            int start = t.start;
            int end = t.end;
            int value =t.value;
            if(find(start) != find(end)) {
                union(start, end);
                answer +=value;
                edge++;
            }

        }
        System.out.println(answer);
    }

    static void union(int start, int end){
        int a = find(start);
        int b = find(end);
        if(a !=b){
            nodes[b] = a;
        }
    }
    static int find(int n){
        if(n==nodes[n]){
            return n;
        }else{
            nodes[n] = find(nodes[n]);
            return nodes[n];
        }
    }
}

