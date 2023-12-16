
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int n, e;
	static ArrayList<int[]>[] list;
	static int[] node;
	static boolean[] chk;
	static int[] cross;
	static int resultFrist = 0;
	static int resultSecond = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		for(int i = 0 ;i <=n; i++) {
			list[i] = new ArrayList<int[]>();
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ;i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to,cost});
		}
		
			bfs(start);
	}
	static void bfs(int start) {
		node = new int[n+1];
		chk = new boolean[n+1];
		Arrays.fill(node, Integer.MAX_VALUE);
		node[start] = 0;
		Queue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
			
		});
		q.add(new int[] {start, 0});
		while(!q.isEmpty()) {
			int[] qOut = q.poll();
			int s = qOut[0];
			if(chk[s]) {
				continue;
			}
			chk[s]= true;
			for(int i = 0 ;i < list[s].size(); i++) {
				int[] next = list[s].get(i);
				if(node[next[0]] > qOut[1] + next[1])
					node[next[0]] = next[1] + qOut[1];
					q.add(new int[] {next[0],node[next[0]]});
				}
			}
		for(int i = 1; i<=n; i++) {
			if(node[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(node[i]);
			}
		}
	}
}