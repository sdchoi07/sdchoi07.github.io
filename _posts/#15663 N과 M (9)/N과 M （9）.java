
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


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
			dfs(n,m );
		System.out.println(sb.toString());
	}
	
	static void dfs(int n, int m ) {
		int beforeNum = 0;
		
		if(m == cnt) {
			for(int i = 0 ;i < map.length; i++) {
				sb.append(map[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0 ;i < n; i++) {
			int dfsNum = limit[i];
			if(!chk[i] && dfsNum != beforeNum) {
				map[cnt] = dfsNum;
				beforeNum = dfsNum;
				cnt++;
				chk[i] = true;
				dfs(n ,m);
				cnt--;
				chk[i] = false;
				
			}
		}
	}
}