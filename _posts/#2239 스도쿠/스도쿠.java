import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    static int[][] map;
    static boolean end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        for(int i= 0; i < 9; i++){
            String str = br.readLine();
            for(int j = 0 ; j <9; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(0);
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.print(map[i][j]);
            }System.out.println(" ");
        }

    }
    static void bfs(int start){

        if(start == 81){
            end = true;
            return;
        }
        int x = start/9;
        int y = start%9;
        if(map[x][y] !=0 ){
            bfs(start+1);
        }else{
            for(int i = 1; i <=9; i++){
                if(!chking(x,y,i)) continue;
                map[x][y] = i;
                bfs(start + 1);

                    if(end)return;
                    map[x][y] = 0;
                    }
                }
            }


    static boolean chking(int x, int y, int n){
        for(int i = 0; i < 9; i++){
            if(map[i][y] ==n || map[x][i] == n){
                return false;
            }
        }
        int dx = x/3 *3;
        int dy = y/3 *3;
        for(int i = dx; i<dx+3; ++i){
            for(int j = dy; j<dy +3; ++j ){
                if(map[i][j] == n) return false;
            }
        }
        return true;
    }
}



