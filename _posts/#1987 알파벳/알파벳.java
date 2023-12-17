import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int r, c;
	static char[][] arr;
	static boolean[] chk;
	static int[] x = {1,0,-1,0};
	static int[] y = {0,1,0,-1};
	static int cnt =1;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		chk = new boolean[26];
		int j = 0;
		
		for(int i = 0 ;i <r; i++) {
			String chars = br.readLine();
			for(int k = 0 ;k <c; k++) {
				arr[i][k] = chars.charAt(k);
			}
		}
		
		int firstNum = arr[0][0] - 'A';
		chk[firstNum] = true;
		bfs(0,0);
		System.out.println(max);
		
	}
	
	static void bfs(int dx, int dy) {
		for(int i = 0 ;i < 4; i++) {
			int nextX = dx+x[i];
			int nextY = dy+y[i];
				if(nextX>=0 && nextX <r && nextY >= 0 && nextY < c) {
					char nextCh = arr[nextX][nextY];
					int chkNum = nextCh -'A';
					if(!chk[chkNum]) {
						cnt++;
						chk[chkNum] = true;
						bfs(nextX, nextY);
						cnt--;
						chk[chkNum] = false;
					}
				}
				max = Math.max(cnt,max);
		}
	}
}