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
	static int cnt = 0;
	static int[] limit;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		map = new int[m];
		chk = new boolean[n];
		limit = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0;i < n; i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(limit);
		for(int i = 0 ;i < limit.length;i++) {
			int num = limit[i];
			map[cnt] = num;
			cnt++;
			chk[i] = true;
			dfs(n,m);
			cnt--;
			chk[i]= false;
		}
		
	}
	
	static void dfs(int n, int m ) {
		
		if(m == cnt) {
			for(int i = 0 ;i < map.length; i++) {
				System.out.print(map[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0 ;i < n; i++) {
			int dfsNum = limit[i];
			if(!chk[i]  ) {
				map[cnt] = dfsNum;
				cnt++;
				chk[i] = true;
				dfs(n ,m);
				cnt--;
				chk[i] = false;
			}
		}
	}
}