import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int n, e;
	static ArrayList<int[]>[] list;
	static boolean[] chk;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		for(int i = 1 ;i <n+1; i++) {
			list[i] = new ArrayList<int[]>();
		}
		
		for(int i = 0 ;i < n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c=  Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b,c});
			list[b].add(new int[] {a,c});
			
		}
		chk = new boolean[n+1];
		for(int i = 1 ;i < list.length;i ++) {
			chk = new boolean[n+1];
			bfs(i, 0);
		}
	System.out.println(result);
	}
	static void bfs(int start, int cost) {
		chk[start] = true;
		result = Math.max(result, cost);
		
		for(int i =0 ;i < list[start].size();i++) {
			int[] next = list[start].get(i);
			int nextNode = next[0];
			int nextCost = next[1];
			if(!chk[nextNode]) {
				bfs(nextNode,cost+nextCost);
			}
			
		}
	}
}