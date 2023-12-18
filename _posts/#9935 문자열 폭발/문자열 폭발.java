
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String str = br.readLine();
		String boomb = br.readLine();
		
		Stack<Character> st = new Stack<>();
		
		for(int i = 0 ; i < str.length(); i++) {
			st.push(str.charAt(i));
			
				if(st.size() >= boomb.length()) {
						boolean flag = true;
						
						for(int j= 0 ;j<boomb.length(); j++) {
							if(st.get(st.size()-boomb.length() +j) != boomb.charAt(j)) {
								flag = false;
								break;
							}
							
						}
						if(flag) {
							for(int j = 0 ; j < boomb.length(); j++) {
								st.pop();
							}
						}
							
				}
		}
		StringBuilder sb = new StringBuilder();
		for(Character a:st) {
			sb.append(a);
		}
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}
}
