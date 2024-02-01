import java.util.*;
class Solution{
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for(int m = 0 ; m < moves.length; m++) {
            int index = moves[m] -1;
            int now = 0;
            boolean chk = true;
            for(int i = 0 ;i < board.length;i++){
                if(board[i][index] != 0){
                    now = board[i][index];
                    if(st.size() >= 1){
                        if(st.peek() == now){

                            st.pop();
                            answer++;
                            chk = false;
                            board[i][index] = 0;
                            break;

                        }
                    }
                        if(chk){
                        st.push(board[i][index]);
                        board[i][index] = 0;
                            break;
                    }
                }
            }
        }
        return answer*2;
    }
}