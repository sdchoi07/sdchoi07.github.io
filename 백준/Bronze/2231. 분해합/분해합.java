import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int answer = 0;
        int b = 0;
        for(int i = 1 ;i <=a; i++) {
            int c =i;
            int sum = c;
            while (c>0) {
                b = c % 10;
                sum += b;
                c = c / 10;
            }
            if(sum == a){
                answer =i;
                break;
            }

        }

        System.out.println(answer);
    }

}
