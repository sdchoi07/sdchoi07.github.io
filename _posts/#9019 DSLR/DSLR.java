
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ;i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			String[] registers = new String[10000]; //레지스터 최대 10000
			boolean[] visited = new boolean[10000]; //방문 최대 10000
			for(int k = 0 ;k < registers.length; k++) {
				registers[k] = "";
			}
			Queue<Integer> q = new LinkedList<Integer>(); 
			
			visited[a] = true;
			q.add(a);
			
			while(!q.isEmpty() && !visited[b]) {
				int now = q.poll();
				int D = (2*now)%10000;             //D일경우
				int S = now == 0? 9999: now-1;     //S일경우
				int L = (now%1000)*10 + now/1000;  //L일경우
				int R = (now%10)*1000 + now/10;    //R일경우
				
				if(!visited[D]) { //4가지 경우 10000까지 계속 반복
					q.add(D);
					visited[D] = true;
					registers[D] = registers[now] + "D";  
				}
				if(!visited[S]) {
					q.add(S);
					visited[S] =true;
					registers[S] = registers[now] + "S";
				}
				if(!visited[L]) {
					q.add(L);
					visited[L] = true;
					registers[L] = registers[now] + "L";
				}
				if(!visited[R]) {
					q.add(R);
					visited[R] = true;
					registers[R] = registers[now] + "R";
				}
			}
	
			System.out.println(registers[b]);
		}
		
	}
}