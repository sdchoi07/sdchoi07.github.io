class Solution{
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zero = 0;
        for(int i = 0 ;i <lottos.length;i++){
            int num = lottos[i];
            if(num == 0){
                zero++;
                continue;
            }
            for(int j = 0 ;j<win_nums.length;j++){
                if(num == win_nums[j]){
                    cnt++;
                    break;
                }
            }
        }
        int result = cnt + zero;
        int results = cnt;
        if(result == 6){
            answer[0] = 1;
        }else if(result == 5){
            answer[0] = 2;
        }else if(result == 4){
            answer[0] = 3;
        }else if(result == 3){
            answer[0] = 4;
        }else if(result == 2){
            answer[0] = 5;
        }else if(result == 1 || results == 0){
            answer[0] = 6;
        }

        if(results == 6){
            answer[1] = 1;
        }else if(results == 5){
            answer[1] = 2;
        }else if(results == 4){
            answer[1] = 3;
        }else if(results == 3){
            answer[1] = 4;
        }else if(results == 2){
            answer[1] = 5;
        }else if(results == 1 || results == 0){
            answer[1] = 6;
        }

        return answer;
    }
}