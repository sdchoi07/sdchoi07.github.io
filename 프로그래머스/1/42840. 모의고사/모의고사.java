class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] q1 = {1,2,3,4,5};
        int[] q2 = {2,1,2,3,2,4,2,5};
        int[] q3 = {3,3,1,1,2,2,4,4,5,5};
        int a1=0;
        int a2=0;
        int a3=0;
        for(int i = 0 ;i < answers.length; i++){
             if(answers[i] == q1[i%q1.length]){
                a1++;
            }
            if(answers[i] == q2[i%q2.length]){
                a2++;
            }
            if(answers[i] == q3[i%q3.length]){
                a3++;
            }

        }
        if( a1> a2 && a1 >a3){
            answer = new int[1];
            answer[0] = 1;
        }else if( a2> a3){
            answer = new int[1];
            answer[0] = 2;
        }else{
            answer = new int[1];
            answer[0] = 3;
        }
        if(a1 == a2 && a1 == a3){
            answer = new int[3];
            answer[0] = 1;
            answer[1] = 2;
            answer[2] = 3;
        }else if(a1 == a2 && a1 > a3){
            answer = new int[2];
            answer[0] = 1;
            answer[1] = 2;
            
        }else if(a1 == a3 && a1 > a2){
            answer = new int[2];
            answer[0] = 1;
            answer[1] = 3;
        }else if( a3== a2 && a2>a1){
            answer = new int[2];
            answer[0] = 2;
            answer[1] = 3;
        }
        return answer;
    }
}