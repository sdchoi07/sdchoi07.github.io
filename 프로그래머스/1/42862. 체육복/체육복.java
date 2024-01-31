import java.util.*;
class Solution{
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> listLost = new ArrayList<>();
        for(int i = 0 ;i < lost.length; i++){
            listLost.add(lost[i]);
        }
        List<Integer> listR = new ArrayList<>();
        for(int i = 0 ; i < reserve.length;i++){
            listR.add(reserve[i]);
        }
        Collections.sort(listLost);
        Collections.sort(listR);
        for(int i = 0 ;i < listLost.size(); i++) {
            int num = listLost.get(i);
            for (int j = 0; j < listR.size(); j++) {
                int comp = listR.get(j);
                if (num == comp) {
                    listLost.remove(i);
                    i--;
                    listR.remove(j);
                    j--;
                    break;
                }
            }
        }
        for(int i = 0 ;i < listLost.size(); i++){
            int num = listLost.get(i);
            for(int j = 0 ;j<listR.size(); j++){
                int comp = listR.get(j);

                if(num -1 == comp || num +1 == comp){
                    System.out.println(listLost + " " + listR);
                    listLost.remove(i);
                    i--;
                    listR.remove(j);
                    j--;
                    break;
                }
            }
        }
            answer = n - listLost.size();

        return answer;
    }
}