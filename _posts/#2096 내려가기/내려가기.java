import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][3];
		int[][] sumMax = new int[n+1][3];
		int[][] sumMin = new int[n+1][3];
		for(int i = 1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		for(int i = 1; i<=n;i++) {
				sumMax[i][0] += Math.max(sumMax[i-1][0], sumMax[i-1][1]) + arr[i][0];
				sumMax[i][1] += Math.max(sumMax[i-1][0],Math.max(sumMax[i-1][1], sumMax[i-1][2])) + arr[i][1];
				sumMax[i][2] += Math.max(sumMax[i-1][1], sumMax[i-1][2]) + arr[i][2];

				sumMin[i][0] += Math.min(sumMin[i-1][0], sumMin[i-1][1]) + arr[i][0];
				sumMin[i][1] += Math.min(sumMin[i-1][0],Math.min(sumMin[i-1][1], sumMin[i-1][2])) + arr[i][1];
				sumMin[i][2] += Math.min(sumMin[i-1][1], sumMin[i-1][2]) + arr[i][2];
				
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0 ;i <3 ;i++) {
			 min = Math.min(min, sumMin[n][i]);
			 max = Math.max(max, sumMax[n][i]);
		}
		System.out.println(max + " "+ min);
	 }
}