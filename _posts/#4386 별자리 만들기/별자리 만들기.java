import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.sqrt;

class Star {
    int i;
    double x, y;


    public Star(int i,double x , double y){
        this.i = i;
        this.x=x;
        this.y=y;
            }
}
class Edge  implements  Comparable<Edge>{
    int start;
    int end;
    double value;
            public Edge(int start, int end, double value){
                this.start = start;
                this.end = end;
                this.value = value;
            }

    @Override
    public int compareTo(Edge o) {
        if(value < o.value) {
            return -1;
        }
        return 1;

    }
}
public class Main {
    static int n, m;

    static Star[] list;
    static ArrayList<Edge> edge;
    static int[] node;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        list = new Star[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());

            list[i] = (new Star(i, a, b));

        }

        edge = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double weight = distance(list[i], list[j]);
                edge.add(new Edge(list[i].i, list[j].i, weight));
            }
        }
        Collections.sort(edge);

        node = new int[n];
        for (int i = 0; i < n; i++) {
            node[i] = i;
        }
        double ans = 0;

        for (int i = 0; i < edge.size(); i++) {
            Edge cur = edge.get(i);

            if (find(cur.start) != find(cur.end)) {
                ans += cur.value;
                union(cur.start, cur.end);
            }
        }
        System.out.printf("%.2f",ans);
    }

    static double distance(Star list1, Star list2) {
        return Math.sqrt(Math.pow(list1.x - list2.x, 2) + Math.pow(list1.y - list2.y, 2));
    }

    static int find(int x) {
        if (x == node[x]) {
            return x;
        }
        return node[x] = find(node[x]);
    }

    static void union(int x, int y) {
        int newX = find(x);
        int newY = find(y);
        if (x != y) {
            node[newX] = newY;
        }
    }

}