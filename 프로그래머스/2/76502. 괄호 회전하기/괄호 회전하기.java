import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int c = s.length()-1;
        int cnt = 0;
        String a = s;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ;i <s.length();i++){
            if(s.charAt(i) == '{' ||s.charAt(i) == '(' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
             if(stack.size()>0) {
                    if (s.charAt(i) == '}' && stack.peek() == '{' || s.charAt(i) == ')' && stack.peek() == '(' || s.charAt(i) == ']' && stack.peek() == '[') {
                        stack.pop();
                    }
                }
        }
        if(stack.isEmpty()){
            if(s.charAt(0) == '}' || s.charAt(0) == ')' || s.charAt(0) == ']'){
               
            }else{
            answer++;
            }
        };
        while(c != cnt){

            cnt++;
            a = s.substring(1,s.length()) + s.substring(0,1);
            s = a;
            if(s.charAt(0) == '}' || s.charAt(0) == ')' || s.charAt(0) == ']'){
                continue;
            }
            stack = new Stack<>();
            for(int i = 0 ;i <s.length();i++){
                if(s.charAt(i) == '{' ||s.charAt(i) == '(' || s.charAt(i) == '['){
                    stack.push(s.charAt(i));
                }
                 if(stack.size()>0) {
                    if (s.charAt(i) == '}' && stack.peek() == '{' || s.charAt(i) == ')' && stack.peek() == '(' || s.charAt(i) == ']' && stack.peek() == '[') {
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty()){
                answer++;
            };

        }
        return answer;
    }
}