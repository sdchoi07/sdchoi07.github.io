import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] chk;
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
		
		map = new int[n][m];
		chk = new boolean[n][m];
		
		for(int i = 0 ;i <n; i++) {
			String nums = br.readLine();
			String[] numArr = nums.split(" ");
			for(int j= 0 ;j <m; j++) {
				int num =Integer.parseInt(numArr[j]);
				map[i][j] = num;
			}
		}
		for(int i = 0 ;i < n; i++) { //{0,0} 부터 시작
			for(int j = 0 ;j<m; j++) {
				cnt++;               //블럭이4개까지이므로 cnt 4까지 체크해야함
				max+=map[i][j];      //cnt4 까지 더해야함
				chk[i][j] =true;     // 방문한곳 안가기
				bfs(i,j);
				chk[i][j] =false;
				cnt = 0;
				max = 0;
			}
		}
		System.out.println(answer);
	}
	static void bfs(int x, int y) {
	
		
		answer = Math.max(max, answer);
		if(cnt == 4) {
			return;
		}
		for(int i = 0 ;i < 4; i++) { //상 하 좌 우 한 번씩 가야하며, 회귀 할때마다 cnt, 방문, 최댓값 반복적으로 더하고 빼야함
			int inX = x+dx[i]; 
			int inY = y+dy[i]; 
			if( inX >=0 && inY >=0 && inX<map.length && inY<map[x].length) {
				
				if(!chk[inX][inY]) {
					if(cnt == 2 ) {    //블럭중 하나가 cnt = 2 일때 들어와서  cnt=3 개일때 다시 cnt가 2 로 돌아와서 x,y 기존 껄로 반복
						chk[inX][inY] = true;
						cnt++;
						max+=map[inX][inY];
						bfs(x,y);
						cnt--;
						chk[inX][inY]= false;
						max-=map[inX][inY];
						
					}
					cnt++;
					chk[inX][inY] = true;
					max+=map[inX][inY];
					bfs(inX,inY);
					cnt--;
					chk[inX][inY] = false;
					max-=map[inX][inY];
				}
			}
		}
	}
}