class Solution {
    public int[] solution(String[] keyinput, int[] board) {
         int[] answer = new int[2];
        for(String way : keyinput) {
        	if(way.equals("right")) {
        		if(answer[0] != board[0]/2) {
        			answer[0]++;
        		}
        	}else if(way.equals("left")) {
        		if(answer[0] != -board[0]/2) {
        			answer[0]--;
        		}
        	}else if(way.equals("up")) {
        		if(answer[1] != board[1]/2) {
        			answer[1]++;
        		}
        	}else {
        		if(answer[1] != -board[1]/2) {
        			answer[1]--;
        		}
        	}
        }
        return answer;
    }
}