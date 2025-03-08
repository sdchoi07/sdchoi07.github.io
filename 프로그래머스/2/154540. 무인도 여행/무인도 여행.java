
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visit;
    public int[] solution(String[] maps) {
        int[] answer = {};
        int row = 0;
        int col = 0;
        int val = 0;
        List<Integer> list = new ArrayList<>();
        visit = new boolean[maps.length][maps[0].length()];
        for(int i = 0 ;i <maps.length;i++) {
        	for(int j = 0 ; j < maps[i].length();j++) {
        		if(maps[i].charAt(j) != 'X') {
        			row = i;
        			col = j;
        			val = Integer.parseInt(String.valueOf(maps[i].charAt(j)));
        			if(visit[row][col])continue;
        			visit[row][col] = true;
        			int value = dfs(row,col,val,maps);
        			if(value !=0)list.add(value);
        		}
    		}
        }
        
        answer = list.stream().sorted().mapToInt(Integer::intValue).toArray();
        if(list.isEmpty()) return answer= new int[] {-1};
        return answer;
    }
    static int dfs(int row, int col, int val, String[] maps) {
		Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row,col,val});
        
        while(!q.isEmpty()) {
        	
        	int[] cur = q.poll();
        	int curRow = cur[0];
        	int curCol = cur[1];
        	
        	
        	for(int i = 0 ;i < 4; i++) {
        		int nextRow = curRow + dx[i];
        		int nextCol = curCol + dy[i];
        		if(nextRow>=0 && maps.length > nextRow && nextCol>=0 && nextCol<maps[0].length() && maps[nextRow].charAt(nextCol) != 'X') {
        			if(visit[nextRow][nextCol]) continue;
        			int nextVal = Integer.parseInt(String.valueOf(maps[nextRow].charAt(nextCol)));
        			q.add(new int[] {nextRow, nextCol, nextVal});
        			
        			val+=nextVal;
        			visit[nextRow][nextCol] = true;
        			
        		}
        	}
        }
        return val;
	}
}