import java.util.*;
class Solution{
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] idx = new double[N];

        int people = stages.length;
        for(int i = 1 ;i <= N; i++) {
            int cnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if(i == stages[j]){
                    cnt++;
                }
            }
            double fail = (double) cnt /people;
            idx[i-1] = fail;
            answer[i-1]=i;
            people-=cnt;
        }

        for(int i = 0 ;i < idx.length;i++){

            for(int j = i+1 ;j < idx.length;j++){
                if(idx[i] < idx[j]){
                    double temp = 0;
                    temp = idx[j];
                    idx[j] = idx[i];
                    idx[i] = temp;

                    int tem = 0;
                    tem = answer[j];
                    answer[j] = answer[i];
                    answer[i] = tem;
                }
            }
        }
        for(int i = 0 ;i < answer.length; i++){
            for(int j = i+1; j<answer.length;j++){
                if(idx[i] == idx[j]){
                    if(answer[i] > answer[j]){
                        int temp = 0;
                        temp = answer[j];
                        answer[j] = answer[i];
                        answer[i] = temp;
                    }
                }
            }
        }
        return answer;
    }

}