

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
static int[][][] arr;
static boolean[][][] visited;
static int[] dx = {1,0,-1,0,0,0};
static int[] dy = {0,1,0,-1,0,0};
static int[] dh = {0,0,0,0,1,-1};
static Queue<int[]> q = new LinkedList<int[]>();
static int count = 0;
static int M,N,H;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr= new int[H][N][M];
		boolean fake = false;
		for(int k=0 ; k<H;k++) {
			for(int i = 0 ;i < N; i++) {
				String str = br.readLine(); 
				st = new StringTokenizer(str);
				for(int j = 0 ;j <M; j++) {
					int num = Integer.parseInt(st.nextToken());
					arr[k][i][j]= num;
					if(num == 1) {
						q.add(new int[]{k,i,j});
					}else if(num == 0) {
						fake = true;
					}
				}
			}
		}
		if(!fake) {
			System.out.println(0);
		}else {
			bfs();
			int max = Integer.MIN_VALUE / 16;
			for(int k = 0; k <H; k++) {
				for(int i = 0 ;i < N; i++) {
					for(int j =0 ; j<M; j++) {
						if(arr[k][i][j] == 0) {
							System.out.println(-1);
							return;
						}if(max < arr[k][i][j]) {
							max = arr[k][i][j];
						}
					}
				}
			}
			System.out.println(max - 1);
		}
	}
	static void bfs() {
		
		while(!q.isEmpty()) {
			
			int[] qOut = q.poll();
			for(int i = 0 ;i < 6; i++) {
				int hInd = qOut[0] + dh[i];
				int xInd = qOut[1] + dx[i];
				int yInd = qOut[2] + dy[i];
					if(Range_check(hInd, xInd, yInd) && arr[hInd][xInd][yInd] == 0  ){
						arr[hInd][xInd][yInd] = arr[qOut[0]][qOut[1]][qOut[2]]+1;
						
						q.add(new int[]{hInd,xInd,yInd});
						}
					}
		}
	
	}
	static boolean Range_check(int hInd, int xInd, int yInd) {
		return (yInd < M && yInd >= 0 && xInd < N && xInd >= 0 &&  hInd < H &&  hInd >= 0);
	}
}
