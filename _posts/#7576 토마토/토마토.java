import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
static int[][] arr;
static boolean[][] visited;
static int[] dx = {1,0,-1,0};
static int[] dy = {0,1,0,-1};
static Queue<int[]> q = new LinkedList<int[]>();
static int count = 0;
static int M,N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0 ;i <N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			for(int j = 0 ;j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				if(num == 1) {
					q.add(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
		
		int result = bfs();
		System.out.println(result);
	}
	static int bfs() {
		
		while(!q.isEmpty()) {
			int[] qOut = q.poll();
			for(int i = 0 ;i < 4; i++) {
				int xInd = qOut[0] + dx[i];
				int yInd = qOut[1] + dy[i];
				if(xInd >=0 && yInd >= 0 && xInd< N  && yInd< M) {
					if(!visited[xInd][yInd] && arr[xInd][yInd] == 0) {
						visited[xInd][yInd] = true;
						arr[xInd][yInd] = arr[qOut[0]][qOut[1]]+1;
						int[] qIn = {xInd,yInd};
						q.add(qIn);
					}
				}
			}
		}
		int MAX = 0;
		for(int i = 0 ;i < N; i++) {
			int num = 0 ;
			for(int j = 0 ;j < M; j++) {
				num = arr[i][j];
				if(MAX <num) {
					MAX = num;
				}
				if(num == 0 ) {
					return -1;
				}
			}
		}
		if(MAX == 1){
			return 0;
		}else {
			return MAX-1;
		}
	}
}
