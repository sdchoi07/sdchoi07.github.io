import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int answer = 0 ;
		answer = bfs(n,k);
		System.out.println(answer);
		
	}
	static int bfs(int n , int k ) {
		Queue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
			
		});
		int[] qIn = {n,0};
		visited[n] = true;
		q.add(qIn);
		while(!q.isEmpty()) {
			int[] qOut = q.poll();
			int dist = qOut[0];
			int time = qOut[1];
			if(dist == k) {
				return time;
			}
			visited[dist] = true;
			if(dist*2<=100000 && !visited[dist*2]) {
				n = dist*2;
				visited[dist*2] = visited[dist];
				q.add(new int[]{n,time});
			}
			if(dist-1>=0 && !visited[dist-1]) {
				n = dist-1;
				q.add(new int[] {n,time+1});
			}
			if(dist +1 <=100000 && !visited[dist + 1]) {
				n = dist+1;
				q.add(new int[]{n,time+1});
			}
			
		}
		return -1;
	}
}