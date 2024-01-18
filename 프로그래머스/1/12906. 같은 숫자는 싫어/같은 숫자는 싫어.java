import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
          Stack<Integer> stack = new Stack<>();
        for(int i = 0 ;i < arr.length; i++){
            if(!stack.isEmpty()) {
                if(stack.peek() != arr[i]){
                    stack.push(arr[i]);
                }
            }else{
                stack.push(arr[i]);
            }
        }
        answer = new int[stack.size()];
        int k = stack.size()-1;
        while(!stack.isEmpty()){
            answer[k--] = stack.pop();
        }

        return answer;
    }
}