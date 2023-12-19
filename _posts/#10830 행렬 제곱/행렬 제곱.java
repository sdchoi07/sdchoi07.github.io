import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int n;
	static int[][] origin;
	static int mod = 1000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());		
		
		origin = new int[n][n];
		
		for(int i = 0 ;i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ;j < n; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken()) % mod;
			}
		}
		
		int result[][] = pow(b);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ;i < n; i++) {
			for(int j = 0 ;j < n;j++) {
				int answer = result[i][j];
					sb.append(answer).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
		static int[][] pow(long b){
			if(b == 1L) {
				return origin;
			}
			
			int result[][] = pow(b/2);
			result = multi(result, result);
			
			if(b%2== 1L) {
				result = multi(result, origin);
			}
			
			return result;
		}
		static int[][] multi(int[][] a, int[][] b){
			int temp[][] = new int[n][n];
			for(int i = 0 ;i < n; i++) {
				for(int j = 0 ; j<n; j++) {
					for(int k = 0 ;k < n; k++) {
						temp[i][j] +=a[i][k] * b[k][j];
						temp[i][j] %=mod;
					}
				}
			}
			return temp;
		}
}
