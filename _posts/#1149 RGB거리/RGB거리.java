
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
static	int cnt = 0;
static int answer = Integer.MAX_VALUE;
static int total =0 ;
//static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][3];
		for(int i = 0 ;i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ;j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 1 ;i < n; i++) {
			arr[i][0] = Math.min(arr[i-1][1], arr[i-1][2]) + arr[i][0];
			arr[i][1] = Math.min(arr[i-1][0], arr[i-1][2]) + arr[i][1];
			arr[i][2] = Math.min(arr[i-1][0], arr[i-1][1]) + arr[i][2];
		}
		System.out.println(Math.min(arr[n-1][0], Math.min(arr[n-1][1], arr[n-1][2])));
	}
}
