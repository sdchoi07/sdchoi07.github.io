class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for(int i = 0 ;i < 4; i++){
            int x = dx[i] + h;
            int y = dy[i] + w;
            if(x < board.length && y< board[0].length && x>=0  && y>=0 ){
                if(color.equals(board[x][y])){
                    answer++;
                }
            }
        }

        return answer;
    }
}