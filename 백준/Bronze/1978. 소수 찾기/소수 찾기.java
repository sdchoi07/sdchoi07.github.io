import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i = 0 ;i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int answer = 0;
		for(int i = 0 ; i<nums.length;i++) {
			if(chk(nums[i])) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	static boolean chk(int num) {
		if(num == 0 || num == 1) return false;
		int cnt = 0;
		for(int i = 2; i<=num; i++) {
			if(num%i== 0) {
				cnt++;
			}
		}
		if(cnt == 1) {
			return true;
		}
		return false;
	}
}
