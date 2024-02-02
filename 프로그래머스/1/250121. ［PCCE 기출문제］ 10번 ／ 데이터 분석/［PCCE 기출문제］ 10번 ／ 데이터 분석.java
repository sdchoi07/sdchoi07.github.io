import java.util.*;
class Solution {
   public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        String[] columns = {"code", "date", "maximum", "remain"};

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                int idxCol = 0;
                for(int i = 0 ;i < columns.length;i++){
                    if(columns[i].equals(sort_by)){
                        idxCol= i;
                        break;
                    }
                }
                return o1[idxCol] - o2[idxCol];
            };
        });
        int idxData = 0;
        for(int i = 0 ;i < columns.length; i++){
            if(columns[i].equals(ext)){
                idxData = i;
            }

        }

        for(int i = 0 ;i < data.length;i++){
            int extractData = Integer.parseInt(String.valueOf(data[i][idxData]));
            if(extractData < val_ext ){
                int extractCode = Integer.parseInt(String.valueOf(data[i][0]));
                int extractDate = Integer.parseInt(String.valueOf(data[i][1]));
                int extractMax = Integer.parseInt(String.valueOf(data[i][2]));
                int extractRemain = Integer.parseInt(String.valueOf(data[i][3]));

                pq.offer(new int[]{extractCode, extractDate, extractMax, extractRemain});
            }
        };
        answer = new int[pq.size()][4];
        int k = 0;
        while(!pq.isEmpty()){
            int[] result = pq.poll();
            answer[k][0] = result[0];
            answer[k][1] = result[1];
            answer[k][2] = result[2];
            answer[k][3] = result[3];
            k++;
        }
        return answer;
    }
}