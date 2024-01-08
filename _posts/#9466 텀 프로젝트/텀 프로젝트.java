import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {

    static int n, m;

    static int answer = 0;
    static int[] students;
    static boolean[] chk;
    static boolean[] team;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ;i <t ;i++) {
            m = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            students = new int[m+1];
            answer = 0;

            for(int j = 1; j < students.length; j++){
                students[j] = Integer.parseInt(str[j-1]);
            }
            chk = new boolean[m+1];
            team = new boolean[m+1];
            for(int j = 1; j < students.length;j++) {
               if(!team[j]) {
                   dfs(j);
               }
            }
            System.out.println(m-answer);
        }
    }
    static void dfs(int start){
        if(chk[start]){
            team[start] = true;

            answer++;
        }else{
            chk[start] = true;
        }
        if(!team[students[start]]){
            dfs(students[start]);
        }
        chk[start] = false;
        team[start] = true;
    }
}