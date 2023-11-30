

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
static int[] map ;
static int[] arr;
static boolean[] visited ;
static int count = 0 ;
static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new int[m];
		visited = new boolean[n];
		arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ;i < arr.length;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
			dfs(n ,m,0);
		System.out.println(sb.toString());
	}
	static void dfs(int n, int m , int k) {
		if(m == count) {
			for(int i = 0 ;i <map.length; i++) {
				sb.append(map[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		int before =0;
		for(int i = k ;i < n; i++) {
			int curNum = arr[i];
			
			if(!visited[i] && curNum != before) {
				before = curNum;
				map[count] = curNum;
				visited[i] = true;
				count++;
				dfs(n,m, i++);
				i--;
				visited[i] = false;
				count--;
			}
		}
	}
}
