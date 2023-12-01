

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
static int[] dp ;
static ArrayList<Integer>[] arr;
static boolean[] visited ;
static int count = 0 ;
static int[] index;
static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1]; 
		index = new int[n+1];
		visited = new boolean[n+1];
		for(int i = 0 ;i <= n ; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i = 0 ;i < n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
			dfs(1); //루트 값을 넘김
		
		for(int i =2 ;i < index.length;i++) {
			System.out.println(index[i]);
		}
	}
	static void dfs(int num ) {
		visited[num] = true; //부모의값 방문
		for(int i = 0 ;i < arr[num].size(); i++) {
			int a = arr[num].get(i); // 자식값 추출
			if(!visited[a]) { //자식값 방문 여부
				index[a] = num;  // 자식배열의 값 넣기
				dfs(a); //자식 값 이 부모값으로 순환 
			}
		}
	}
	
}
