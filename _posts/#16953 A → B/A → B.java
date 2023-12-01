
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
static	int answer;
static  boolean[] visited;
static  long a ,b;
//static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int cnt = 0 ;
		bfs(a, cnt);
		
		if(answer == 0) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
	}
	static void bfs(long x, int cnt) {
		cnt++;
		if(x == b ) {
			answer = cnt;
				return;
			}else if(x >b) {
				return;
			}
			
			String numStr = String.valueOf(x) + "1";
			long num = Long.parseLong(numStr);
			
			bfs(x*2, cnt);
			bfs(num, cnt);
			
	}
	
}
