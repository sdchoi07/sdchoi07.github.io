
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int  t = Integer.parseInt(st.nextToken());
		for(int i = 0 ;i < t; i++) {
			int n = Integer.parseInt(br.readLine());
		
			int[][] arr= new int[2][n];
			for(int j = 0 ;j < 2; j++) {
				st= new StringTokenizer(br.readLine(), " ");
				for(int k = 0; k <n; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int r = 1; r < n; r++) {
				int up = Math.max(arr[0][r] + arr[1][r-1], Math.max(arr[0][r-1], arr[1][r-1]));
				int down = Math.max(arr[1][r] + arr[0][r-1], Math.max(arr[0][r-1], arr[1][r-1]));
				arr[0][r] = up;
				arr[1][r] = down;
			}
			int max = 0;
			int answer = 0 ;
			for(int s = 0 ;s <2; s++) {
				for(int j = 0 ;j <n; j++) {
					answer = Math.max(arr[s][j], max);
					max = answer;
				}
			}
			System.out.println(max);
		}
	}
}