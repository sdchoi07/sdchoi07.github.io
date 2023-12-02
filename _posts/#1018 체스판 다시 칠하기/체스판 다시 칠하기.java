
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static boolean[][] arr;
	public static int min = 64;
//static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0 ;j < m ; j++) {
				if(str.charAt(j) == 'W') {
					arr[i][j] = true;
				}else {
					arr[i][j] = false;
				}
				
			}
		}
		
		int nX = n - 7;
		int mY = m - 7;
		
		for(int i = 0 ;i < nX; i++) {
			for(int j = 0 ;j < mY; j++) {
				find(i,j);
			}
		}
		System.out.println(min);
	}
	
	static void find(int x, int y) {
		int xIndex = x + 8;
		int yIndex = y + 8;
		int count = 0;
		
		boolean chk = arr[x][y];
		for(int i = x ; i<xIndex; i++) {
			for(int j= y ; j<yIndex;j++) {
				if(arr[i][j] != chk) {
					count++;
				}
				 
			 chk = !chk;
			}
			chk = !chk;
		}
		count = Math.min(count, 64 - count);
		
		min = Math.min(min, count);
		
	}
}
