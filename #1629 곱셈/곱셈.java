import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static long c;
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		
		long a = in.nextLong();
		long b = in.nextLong();
		c = in.nextLong();
		
		
		System.out.println( maths(a, b));
	}
	static long maths(long a, long b) {
		if(b == 1) {
			return a%c;
		}
		
		long mod = maths(a, b/2);
		
		if(b % 2 ==1 ) {
			return (mod *mod % c) * a%c;
		}
		return mod*mod%c;
	}
}
