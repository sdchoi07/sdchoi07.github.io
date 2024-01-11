import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    static int n;
    static int[][] games;
    static int[][] copy;
    static int cnt;
    static int[] ways;
    static int answer =0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        games = new int[n][n];
        copy = new int[n][n];
        ways = new int[5];
        for(int i = 0 ;i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ;j < n; j++){
                games[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = games[i][j];
            }
        }
        game(0);

        System.out.println(answer );
    }
    static void game(int count){
        if(count == 5) {

            init();
            for (int i = 0; i < 5; i++) {
                int a = ways[i];
                move(a);
            }

            int sum = 0;
            for(int i = 0 ; i< n; i++){
                for(int j = 0 ;j<n; j++){
                    sum = Math.max(sum, games[i][j]);
                }
            }
            answer = Math.max(answer, sum);
            return;
        }
        for(int i = 0 ;i<4; i++){
            ways[count] = i;
            game(count+1);
        }
    }
    static void move(int direciton) {
        switch (direciton) {
            case 0:
                for(int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for(int j = n - 1; j >= 0; j--) {
                        if(games[i][j] != 0) {
                            if(block == games[i][j]) {
                                games[i][index + 1] = block * 2;
                                block = 0;
                                games[i][j] = 0;
                            }
                            else {
                                block = games[i][j];
                                games[i][j] = 0;
                                games[i][index] = block;
                                index--;
                            }
                        }
                    }
                }

                break;
            case 1:
                for (int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j <n; j++) {
                        if(games[i][j] != 0) {
                            if(block == games[i][j]) {
                                games[i][index - 1] = block * 2;
                                block = 0;
                                games[i][j] = 0;
                            }
                            else {
                                block = games[i][j];
                                games[i][j] = 0;
                                games[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < n ; i++) {
                    int index = 0;
                    int block = 0;
                    for(int j = 0; j <n; j++) {
                        if(games[j][i] != 0) {
                            if(block == games[j][i]) {
                                games[index-1][i] = block * 2;
                                block = 0;
                                games[j][i] = 0;
                            }
                            else {
                                block = games[j][i];
                                games[j][i] = 0;
                                games[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i<n; i++) {
                    int index = n-1;
                    int block = 0;
                    for(int j = n -1; j >=0; j--) {
                        if(games[j][i] != 0) {
                            if(block == games[j][i]) {
                                games[index+1][i] = block * 2;
                                block = 0;
                                games[j][i] = 0;
                            }
                            else {
                                block = games[j][i];
                                games[j][i] = 0;
                                games[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
        }
    }
    static int result(){
        int max = 0;
        for(int i = 0 ;i < n; i++){
            for(int j = 0 ;j < n; j++){
                Math.max(max, games[i][j]);
            }
        }
        return max;
    }
    static void init(){
        for(int i = 0 ;i < n; i++){
            for(int j = 0 ;j < n; j++){
                games[i][j] = copy[i][j];
            }
        }
    }
}