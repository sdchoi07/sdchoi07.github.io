import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.sqrt;
class Bags {
    int weight, cost;
            public Bags(int weight, int cost){
                this.weight = weight;
                this.cost = cost;
            }

}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Bags> list = new ArrayList<>();

        for(int i = 0 ;i < n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Bags(weight, cost));


        }
        
        Collections.sort(list, ((o1, o2) -> o1.weight - o2.weight));
        int[] maxWeight = new int[k];
        for(int i = 0 ;i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            maxWeight[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(maxWeight);
        long[] answer = new long[k];
        PriorityQueue<Bags> q = new PriorityQueue<>((o1,o2)-> o2.cost- o1.cost);

        int idx = 0;
        long sum = 0;
        for(int i = 0 ; i <k; i++){
            while(idx< n &&list.get(idx).weight <= maxWeight[i]){
                Bags bag = list.get(idx++);
                q.add(new Bags(bag.weight,bag.cost));
            }
            if(!q.isEmpty()) sum+=q.poll().cost;
        }
//        for(int i = 0 ; i < answer.length; i++){
//            sum+=answer[i];
//        }
        System.out.println(sum);
    }
}