
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] map;
	static boolean[] chk;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int max = 0;
	static int answer = 0;
	static int cnt =0;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		chk = new boolean[n];
		map = new int[m];
		for(int i = 0 ;i < n; i++) {
			map[cnt] = i+1;
			cnt++;
			dfs(n,m );
			cnt = 0;
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int n, int m) {
		if(m == cnt) {
			for(int i = 0 ; i< map.length; i++) {
				sb.append(map[i]+ " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0;i < n; i++) {
				if(!chk[i]) {
						map[cnt] = i+1;
						cnt++;
						dfs(n,m);
						cnt--;
			}
		}
	}
}