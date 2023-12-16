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
	static int[] nums;
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
		for(int i = 1 ;i <=n; i++) {
			list[i] = new ArrayList<int[]>();
		}
		
		for(int i = 0 ;i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new int[]{to,cost});
			list[to].add(new int[] {from,cost});
		}
		st = new StringTokenizer(br.readLine(), " ");
		int frist = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
				
		bfs(1, frist, true);
		bfs(frist, second, true);
		bfs(second, n, true);

		bfs(1, second, false);
		bfs(second, frist, false);
		bfs(frist, n, false);
		if(resultFrist >= Integer.MAX_VALUE/4 && resultSecond >=Integer.MAX_VALUE/4) {
			System.out.println(-1);
		}else {
			System.out.println(Math.min(resultFrist, resultSecond));
		}
	}
	static void bfs(int start, int end, boolean flag) {
		nums = new int[n+1]; 
		chk  = new boolean[n+1];
		Arrays.fill(nums, Integer.MAX_VALUE/4);	
		
		if(start == end) {
			return;
		}else {
			int result = 0;
			Queue<int[]> q = new PriorityQueue<int[]>(new Comparator<int []>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1]-o2[1];
				}
				
			});
			
			q.add(new int[]{start,0});
			while(!q.isEmpty()) {
				int[] qOut = q.poll();
				int node = qOut[0];
				if(chk[node]) {
					continue;
				}
				chk[node] = true;
				for(int i = 0; i <list[node].size(); i++) {
					int[] next = list[node].get(i);
					if(next != null) {
						if(nums[next[0]] > qOut[1] + next[1] ) {
							
							nums[next[0]] =qOut[1]+next[1];
							q.add(new int[] {next[0], nums[next[0]] });
						}
					}
				}
				
				
			}
			result = nums[end];
			if(flag) {
				resultFrist+=result;
			}else {
				resultSecond+=result;
			}
		}
		
	}
}