
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		chk = new boolean[n];
		map = new int[m];
		for(int i = 0 ;i < n; i++) {
			map[cnt] = i+1;
			cnt++;
			dfs(n,m ,i);
			chk[i] = true;
			cnt = 0;
		}
	}
	
	static void dfs(int n, int m, int k) {
		if(m == cnt) {
			for(int i = 0 ; i< map.length; i++) {
				System.out.print(map[i]+ " ");
			}
			System.out.println();
			return;
		}
		for(int i = k;i < n; i++) {
				if(!chk[i]) {
						map[cnt] = i+1;
						cnt++;
						dfs(n,m, i++);
						cnt--;
						i--;
			}
		}
	}
}