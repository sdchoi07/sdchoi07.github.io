
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
			dfs(n,m ,0);
			cnt--;
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int n, int m ,int k) {
		
		if(m == cnt) {
			for(int i = 0 ;i < map.length; i++) {
				sb.append(map[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0 ;i < n; i++) {
			int dfsNum = limit[i];
			if(!chk[i]  ) {
				map[cnt] = dfsNum;
				cnt++;
				dfs(n ,m, i++);
				cnt--;
				i--;
			}
		}
	}
}