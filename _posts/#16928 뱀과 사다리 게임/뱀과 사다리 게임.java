import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
static int[] snake;
static Map<Integer, Integer> sMap;
static boolean[] visited;
static int[] dx = {1,0,-1,0};
static int[] dy = {0,1,0,-1};
static Queue<int[]> q = new LinkedList<int[]>();
static int count = 0;
static int N, M;
static int[] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[101];          //1~100까지 지도 만들기
		snake = new int[101];        // 뱀이랑사다리 만들기
		visited = new boolean[101];  // 방문한곳
		for(int i = 0 ; i <N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			snake[a] = b; //연결된 숫자 입력
		}
		bfs();
		
		
	}
	static void bfs() {
		Queue<Integer> q= new LinkedList<Integer>();
		q.offer(1);
		map[1] = 0;
		visited[1] = true; //1부터 출발 
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == 100) { //100이면 끝
				System.out.println(map[cur]);
				return;
			}
			
			for(int i = 1; i < 7; i++) { //주사위 최대 6까지 이므로 현재위치부터 +6까지는 같은 횟수
				int x = cur + i;
				if(100 <x)continue;
				if(visited[x])continue;
				visited[x] = true;
				
				if(snake[x] != 0){
                    if(!visited[snake[x]]) { //지도위 숫자가 뱀또는 사다리 일경우
					q.offer(snake[x]);
					visited[snake[x]] = true;
					map[snake[x]] = map[cur]+1;
                    }
				}else { //숫자 뱀 이 아닐경우 
					q.offer(x);
					map[x] = map[cur] +1;
					
				}
			}
		}
		
	}
}