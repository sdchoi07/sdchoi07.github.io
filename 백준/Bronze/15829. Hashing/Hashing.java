import java.util.Scanner;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String L = sc.next();
		
		
		long sum = 0;
		long num = 0;
		long x = 31;
		for(int i = 0 ;i < L.length(); i++) {
			switch(String.valueOf(L.charAt(i))) {
			case "a" : num = 1;
				  break;
			case "b" : num = 2;
			break;
			case "c" : num = 3;
			break;
			case "d" : num = 4;
			break;
			case "e" : num = 5;
			break;
			case "f" : num = 6;
			break;
			case "g" : num = 7;
			break;
			case "h" : num = 8;
			break;
			case "i" : num = 9;
			break;
			case "j" : num = 10;
			break;
			case "k" : num = 11;
			break;
			case "l" : num = 12;
			break;
			case "m" : num = 13;
			break;
			case "n" : num = 14;
			break;
			case "o" : num = 15;
			break;
			case "p" : num = 16;
			break;
			case "q" : num = 17;
			break;
			case "r" : num = 18;
			break;
			case "s" : num = 19;
			break;
			case "t" : num = 20;
			break;
			case "u" : num = 21;
			break;
			case "v" : num = 22;
			break;
			case "w" : num = 23;
			break;
			case "x" : num = 24;
			break;
			case "y" : num = 25;
			break;
			case "z" : num = 26;
			break;
			}
			if( i == 0 ) {
				sum+= num;
			}else {
			sum += num * x % 1234567891; 
			x =x*31 % 1234567891;
			}
		}
		
			System.out.println(sum % 1234567891);
		
	}
		
}
