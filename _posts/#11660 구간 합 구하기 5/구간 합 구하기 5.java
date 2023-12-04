
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
static int n ,m;
static int[][] arr;
	
static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		int[][] sum = new int[n+1][n+1];
		for(int i = 1 ;i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1 ;j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] = arr[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
			}
		}
		for(int i = 0 ;i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
		
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			System.out.println(sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1]);
		}
		
	}
	
}