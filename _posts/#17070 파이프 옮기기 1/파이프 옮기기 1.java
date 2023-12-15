import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> home;
	static int[][][] dp;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i= 0 ;i <N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j =0; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int [N][N][3];
		dp[0][1][0] = 1;
		for(int i = 0 ;i < N; i++) {
			for(int j = 2 ;j <N;j++) {
				
				if(map[i][j] == 0) {
					dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
					
					if(i-1>=0) {
						dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
						
						
						if(map[i-1][j] == 0 && map[i][j-1] == 0) {
							dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
						}
					}
					
				}
			}
		}
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}
}