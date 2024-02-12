import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<int[]> q= new LinkedList<>();
        for(int i = 0 ;i < progresses.length; i++){
            q.offer(new int[]{progresses[i], speeds[i],0,i});
        }
        int[] nums = new int[progresses.length];

        while(!q.isEmpty()){

            int[] arr = q.poll();
            int pro = arr[0];
            int speed = arr[1];
            pro = pro+speed;
            int days = arr[2];
            int idx = arr[3];
            days++;
            if(pro >= 100){
                nums[idx] = days;
                continue;
            }else{
                q.offer(new int[]{pro,speed,days,idx});
            }

        }
        int t = 0;
        for(int i = 0 ;i < nums.length; i++){
            int cnt = 1;
            int stand = nums[i];
            for(int j = i+1; j<nums.length; j++){

                if(stand < nums[j]){
                    break;
                }else{
                    cnt++;
                }
            }
            i = i+cnt-1;
            t++;
        }
        answer = new int[t];
        int k = 0;
        for(int i = 0 ;i < nums.length; i++){
            int cnt = 1;
            int stand = nums[i];
            for(int j = i+1; j<nums.length; j++){

                if(stand < nums[j]){
                    break;
                }else{
                    cnt++;
                }
            }
            i = i+cnt-1;
            answer[k++] = cnt;
        }

        return answer;
    }
}