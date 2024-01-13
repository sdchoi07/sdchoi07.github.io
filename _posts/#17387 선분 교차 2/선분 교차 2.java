import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.sqrt;
class Point{
    long x, y;
    public Point(long x, long y){
        this.x=x;
        this.y=y;

    }
}
public class Main {
    static HashMap<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long x1, y1, x2, y2, x3, y3, x4, y4;
        Point[] point = new Point[4];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine()," ");

        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());
        x4 = Integer.parseInt(st.nextToken());
        y4 = Integer.parseInt(st.nextToken());

        point[0] = new Point(x1,y1);
        point[1] = new Point(x2,y2);
        point[2] = new Point(x3,y3);
        point[3] = new Point(x4,y4);
        int answer = checkCCW(point);
        System.out.println(answer);
    }
    static int checkCCW(Point[] p){
        boolean chk = false;
        int result = 0;
        int p123 = ccw(p[0],p[1],p[2]);
        int p124 = ccw(p[0],p[1],p[3]);
        int p341 = ccw(p[2],p[3],p[0]);
        int p342 = ccw(p[2],p[3],p[1]);
        boolean compare1 = Math.min(p[0].x,p[1].x) <= Math.max(p[2].x, p[3].x);
        boolean compare2 = Math.min(p[0].y,p[1].y) <= Math.max(p[2].y,p[3].y);
        boolean compare3 = Math.min(p[2].x,p[3].x) <= Math.max(p[0].x,p[1].x);
        boolean compare4 = Math.min(p[2].y,p[3].y) <= Math.max(p[0].y,p[1].y);
        if(p123 * p124 == 0 && p341 * p342 == 0){
            chk = true;
            if(compare1 && compare2 && compare3 && compare4){
                result =1;
            }
        }
        if(p123*p124<=0 && p341*p342<=0){
            if(!chk){
                result =1;
            }
        }
        return result;
    }

    static int ccw(Point p1, Point p2, Point p3){
        long result = ((p1.x * p2.y) + (p2.x*p3.y) +(p3.x*p1.y)) - ((p2.x * p1.y) + (p3.x*p2.y) +(p1.x*p3.y));
        if(result <0){
            return 1;
        }else if(  result == 0){
            return 0;
        }else{
            return -1;
        }

    }
}