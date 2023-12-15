
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int people = Integer.parseInt(st.nextToken());
		boolean[] knowTruth = new boolean[N+1];
		int[] truth = new int[people];
		for(int i = 0 ;i <people; i++) {
			int a = Integer.parseInt(st.nextToken());
			truth[i] = a;
			knowTruth[a] = true;
		}
		
		int[] parents = new int[N+1];
		for(int i = 0 ;i <=N;i++) {
			parents[i] = i;
		}
		
		int count = 0;
		ArrayList<Integer>[] list = new ArrayList[M];
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			people = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<Integer>();
			for(int j= 0 ;j<people; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i = 0 ;i <M; i++) {
			for(int j=0;j<list[i].size()-1;j++) {
				union(parents,list[i].get(j), list[i].get(j+1));
			}
		}
		for(int i = 1; i<=N; i++) {
			if(knowTruth[i]) {
				int parent = find(parents,i);
				knowTruth[parent] = true;
			}
		}
		int answer = 0;
		for(int i = 0 ;i < M; i++) {
			boolean flag = true;
			for(int j = 0 ; j<list[i].size(); j++) {
				int partyPerson = list[i].get(j);
				int parent = find(parents, partyPerson);
				if(knowTruth[parent]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	static int find(int[] parents,int i ) {
		if(parents[i] == i) {
			return i;
		}
		return parents[i] = find(parents ,parents[i]);
	}
	static void union(int[] parents, int x, int y ) {
		int u = find(parents, x);
		int v = find(parents, y);
		if(u == v)return;
		else parents[v] = u;
	}
}