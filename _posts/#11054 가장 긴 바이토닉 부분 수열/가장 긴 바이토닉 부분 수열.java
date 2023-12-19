import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[] list;
    static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        list = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int[] dpR = new int[n+1];
        int[] dpL = new int[n+1];
        int pre = 0;
        for(int i = 1 ; i < list.length; i++) {
            dpR[i] = 1;
            for (int j = 1; j < i; j++) {
                if (list[i] > list[j]) {
                    dpR[i] = Math.max(dpR[j] + 1, dpR[i]);

                }

            }
        }
        for(int i = n; i>0; i--){
            dpL[i] = 1;
            for(int j = n;j >=i; j--){
                if(list[i] > list[j]){
                    dpL[i] = Math.max(dpL[j]+1, dpL[i]);
                }

            }
        }
        int max= 0;
        for(int i = 0 ;i < dpR.length; i++){
            max = Math.max(dpR[i] + dpL[i], max);
        }
        System.out.println(max-1);
    }

}