import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int count = 0;
        int answer = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int k = 0 ;k < a; k++) {
            count = 0;
            int b = Integer.parseInt(st.nextToken());
            for(int i = 2 ;i <=b; i++){
                if(b%i == 0){
                    count++;
                }
            }
            if(count == 1){
                answer++;
            }
        }
        System.out.println(answer);

    }

}
