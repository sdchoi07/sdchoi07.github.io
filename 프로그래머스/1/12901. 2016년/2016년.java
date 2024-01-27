import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
class Solution {
    public String solution(int a, int b) throws ParseException {
        String answer = "";
        Date date = null;
        Calendar cal = Calendar.getInstance();

;

        String year = "2016";
        String month = String.valueOf(a);
        String days = String.valueOf(b);
        if(a<10){
            month ="0"+String.valueOf(a);
        }
        if(b<10){
            days ="0"+String.valueOf(b);
        }
        String today = year+month+days;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        date = dateFormat.parse(today);
        cal.setTime(date);
        int  dayNum = cal.get(Calendar.DAY_OF_WEEK);
        switch(dayNum) {
            case 1:
                answer = "SUN";
                break;
            case 2:
                answer = "MON";
                break;
            case 3:
                answer = "TUE";
                break;
            case 4:
                answer = "WED";
                break;
            case 5:
                answer = "THU";
                break;
            case 6:
                answer = "FRI";
                break;
            case 7:
                answer = "SAT";
                break;
        }
        return answer;
    }
}