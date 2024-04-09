import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
		int i=0;
		int a = num1;
		int b = num2;
		int max = 1;
		int min = 0 ;
		for( i = 2; i < num1*num2; i++) {
			if( a%i == 0 && b%i==0) {
				max *=i;
				a = a/i;
				b = b/i;
				i--;
				min = max * a * b;
			}
		}
        if(min == 0 ) {
			min = a*b;
		}
		System.out.println(max + "\n" + min);
	}
		
}
