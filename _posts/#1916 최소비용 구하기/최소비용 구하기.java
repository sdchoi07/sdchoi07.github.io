import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]>[] arr;
	static int[] bus;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int max = Integer.MAX_VALUE;
		arr = new ArrayList[n+1];
		bus = new int[n+1];
		visited = new boolean[n+1];
		for(int i = 1; i<=n; i++) {
			bus[i]=max;
		}
		
		for(int i = 1 ;i <= n; i++) {
			arr[i] = new ArrayList<int[]>(); //배열로 초기화 해줘야함
		}
		
		for(int i = 0 ;i < m; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int[] s = new int[2];
			s[0] = Integer.parseInt(st.nextToken());
			s[1] = Integer.parseInt(st.nextToken());
			arr[a].add(s);
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		bfs(n,m,a); //출발 값을 넘김

		int answer = bus[b]; //목적지 값 넣으면 답
		System.out.println(answer);
		
	}
	 static void bfs(int n , int m,int a) {
		 bus[a] = 0; //출발 값은 0으로 선언
		 Queue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() { //우선순위 거리값으로 해줘야함

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
			 
			 
		 }) ;
		 int[] qIn = {0,a}; //출발 값은 0이기때문에 0으로 시작
		 q.add(qIn);
		 while(!q.isEmpty()) {
			 int[] current = q.poll(); // 거리값이 낮은 것부터 할당
			 int node = current[1]; //첫번째 값은 value 두번째값은 정류장이므로 1을 넣음
			 if(visited[node])continue; //방문했으면 넘어감

			 visited[node] = true;
			 for(int i = 0 ; i < arr[node].size(); i++) { // 초기에 ArryList 안에 배열로 한 이유
				 int next = arr[node].get(i)[0]; //0은 다음 목적지
				 int value = arr[node].get(i)[1]; //1은 거리값
				 if(bus[next]> bus[node] + value) {  
					 bus[next] = bus[node] + value;
					 int[] qs = {bus[next],next};
					 q.add(qs);
				 }
				 
			 }
		 }
	 }
}