import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Tree{
    int node, value;

    Tree(int node, int value){
        this.node = node;
        this.value =value;
    }
}
public class Main {


    static int v;
    static boolean[] chk;
    static ArrayList<Tree>[] list ;
    static int lastNode = 0;
    static int dist = 0;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        list = new ArrayList[v+1];
        chk = new boolean[v+1];
        for(int i = 1;i <= v ; i++){
            list[i] = new ArrayList<Tree>();
        }

        for(int i = 0 ;i < v; i++){
            String str = br.readLine();
            String[] strArr = str.split(" ");
            int start = Integer.parseInt(strArr[0]);
            int end = 0;
            int value = 0;
            for(int j = 1 ;j <strArr.length; j+=2) {
                if(strArr.length -1 == j){
                    continue;
                }
                   end = Integer.parseInt(strArr[j]);
                   value = Integer.parseInt(strArr[j+1]);
                list[start].add(new Tree(end, value));
            }

        }

            dist = 0;
            chk = new boolean[v+1];
            chk[1] = true;
            dij(1);

            dist = 0;
            chk = new boolean[v+1];
            chk[lastNode] = true;
            dij(lastNode);

        System.out.println(result);
    }

    static void dij(int start){

        for(int i = 0 ;i < list[start].size() ; i++){
            Tree tree = list[start].get(i);
            int node = tree.node;
            int value = tree.value;
            if(!chk[node]){
                chk[node] = true;
                dist+=value;
                dij(node);
                chk[node] = false;
                dist-=value;
            }
        };
        if(result < dist){
            result = dist;
            lastNode = start;
        }
    }
}

