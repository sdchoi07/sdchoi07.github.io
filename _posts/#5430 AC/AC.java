

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ;i < t; i++) {
			Deque<Integer> d = new ArrayDeque<Integer>();
			String functions = br.readLine();
			String[] function = functions.split("");
			
			int m = Integer.parseInt(br.readLine());
			int cnt = 0;
			st = new StringTokenizer(br.readLine(), "[],");
			for(int j = 0 ;j <m; j++) {
				d.add(Integer.parseInt(st.nextToken()));
			}
			boolean chk = true;
			for(int j = 0 ;j< function.length; j++) {
					if(function[j].equals("R")) {
						chk = !chk;
						continue;
					}
					
					if(chk) {
						if(d.pollFirst() == null) {
							cnt = 1;
							break;
						}
						
					}else {
						if(d.pollLast() == null){
							cnt = 1;
							break;
						}
					}
				}
			
			if(cnt == 1 ) {
				sb.append("error").append("\n");
			}else if(d.size() == 0) {
				sb.append("[]").append("\n");
			}else {
				sb.append("[");
				if(chk) {
					sb.append(d.pollFirst());
					while(!d.isEmpty()) {
						sb.append(",").append(d.pollFirst());
					}
					sb.append("]");
					sb.append("\n");
				}else {
					sb.append(d.pollLast());
					while(!d.isEmpty()) {
						sb.append(",").append(d.pollLast());
					}
					sb.append("]");
					sb.append("\n");
				}
			}
			}
		System.out.println(sb.toString());
	}

}
