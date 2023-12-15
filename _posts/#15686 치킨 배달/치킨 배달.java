
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> home;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		for(int i = 0 ;i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ;j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					home.add(new int[] {i,j});
				}
				if(num == 2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		answer = Integer.MAX_VALUE;
		bfs(new int[M], 0 , 0);
		System.out.println(answer);
	}
	static void bfs(int[] count, int start, int end) {
		if(count.length == end) {
			int result = 0;
			for(int i = 0 ;i < home.size();i++) {
				int dist = Integer.MAX_VALUE;
				for(int j = 0 ;j < count.length; j++) {
					int min = Math.abs(chicken.get(count[j])[0] - home.get(i)[0]) + Math.abs(chicken.get(count[j])[1] - home.get(i)[1]);
					dist = Math.min(dist, min);
				}
				result+=dist;
			}
			answer = Math.min(answer, result);
			return;
		}
		
		for(int i = start; i<chicken.size();i++) {
			count[end] = i;
			bfs(count, i+1, end+1);
		}
	}
}