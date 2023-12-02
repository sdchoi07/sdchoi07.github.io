

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
static int[] dp ;
static int[] arr;
static boolean[] visited ;
static int count = 0 ;
static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		dp = new int [n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ;i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			dfs(i);
		}
		int answer = 0 ;
		for(int i = 0 ;i < dp.length; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
	static int dfs(int x) {
		for(int i = 0 ;i<x; i++) {
			if(arr[x] > arr[i] && dp[x] < dp[i]+1) {
				dp[x] = dp[i]+1;
			}
		}
		return dp[x];
	}
}
