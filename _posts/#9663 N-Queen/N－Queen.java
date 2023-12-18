
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	static int cnt = 0;
	static int n;
	static int[] arr;
	static int[] x = {1,0,-1,0};
	static int[] y = {0,1,0,-1};
	static int answer = 0;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
					bfs(0);
		System.out.println(answer);
	}
	static void bfs(int depth) {
		if(depth == n) {
			answer++;
			return;
		}
		for(int i = 0 ;i < n ; i++) {
			arr[depth] = i;
			boolean chk = true;
			for(int j = 0 ;j < depth; j++) {
				if(arr[depth] == arr[j]) {
					chk = false;
				}
				if(Math.abs(depth - j) == Math.abs(arr[depth] -arr[j])) {
					chk = false;
				}
				if(!chk) {
					break;
				}
		}
			if(chk) {
				bfs(depth+1);
			}
	}
}
}
