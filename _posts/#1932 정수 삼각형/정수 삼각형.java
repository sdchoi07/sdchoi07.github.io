
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
//static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] arr = new ArrayList[n];
		for(int i = 0 ;i < n; i ++) {
			arr[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ;j <=i; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i].add(num);
			}
		}
		
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0 ;j<arr[i].size(); j++) {
				int sum ;
				if(j == 0 ) {
					sum = arr[i].get(j) + arr[i-1].get(j);
				}else if(j == arr[i].size()-1) {
					sum = arr[i].get(j) + arr[i-1].get(j-1);
				}else {
					sum = Math.max(arr[i].get(j)+arr[i-1].get(j-1) , arr[i].get(j) + arr[i-1].get(j));
				}
				arr[i].set(j, sum); 
			}
		}
		int answer =0 ;
		for(int i = 0 ; i <arr[n-1].size(); i++) {
			answer = Math.max(answer, arr[n-1].get(i));
		}
		System.out.println(answer);
	}
}
