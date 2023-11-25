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
static String[][] arr;
static String[][] arr2;
static boolean[][] visited;
static int[] dx = {1,0,-1,0};
static int[] dy = {0,1,0,-1};
static Queue<int[]> q = new LinkedList<int[]>();
static int count = 0;
static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		arr = new String[N][N];
		arr2 = new String[N][N];
		visited = new boolean[N][N];
		for(int i = 0 ;i <N; i++) {
			String s = br.readLine();
			for(int j = 0 ;j<N; j++) {
				arr[i][j] = String.valueOf(s.charAt(j));
				if(s.charAt(j) == 'G') {
					arr2[i][j] = "R";
				}else {
					arr2[i][j] = String.valueOf(s.charAt(j));
					
				}
			}
		}
		
		int count1 = 0 ;
		for(int i = 0 ;i < N; i++) {
			for(int j = 0 ;j < N;j++) {
				if(!visited[i][j]) {
					count1++;
					bfs(i,j, 0);
				}
			}
		}
		int count2 = 0;
		visited = new boolean[N][N];
		for(int i = 0 ;i < N; i++) {
			for(int j = 0 ;j < N;j++) {
				if(!visited[i][j]) {
					count2++;
					bfs(i,j,1);
				}
			}
		}
		
		
		System.out.println(count1 + " " +count2);
	}
	static void bfs(int x , int y, int gubun) {
		if(gubun == 0) {
			String color = arr[x][y];
			visited[x][y] = true;
			q.add(new int[] {x,y});
			while(!q.isEmpty()) {
				int[] qOut = q.poll();
				for(int i = 0 ;i < 4; i++) {
					int xInd = qOut[0] + dx[i];
					int yInd = qOut[1] + dy[i];
					if(xInd >=0 && yInd >=0 && xInd<arr.length && yInd<arr.length) {
						if(!visited[xInd][yInd] && color.equals(arr[xInd][yInd])) {
							visited[xInd][yInd] = true;
							q.add(new int[] {xInd,yInd});
						}
					}
				}
			}
		}else {
			String color = arr2[x][y];
			visited[x][y] = true;
			q.add(new int[] {x,y});
			while(!q.isEmpty()) {
				int[] qOut = q.poll();
				for(int i = 0 ;i < 4; i++) {
					int xInd = qOut[0] + dx[i];
					int yInd = qOut[1] + dy[i];
					if(xInd >=0 && yInd >=0 && xInd<arr.length && yInd<arr.length) {
						if(!visited[xInd][yInd] && color.equals(arr2[xInd][yInd])) {
							visited[xInd][yInd] = true;
							q.add(new int[] {xInd,yInd});
						}
					}
				}
			}
		}
	}
}
