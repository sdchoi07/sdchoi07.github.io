import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        int todayYYYY = Integer.parseInt(today.substring(0,4));
        int todayMonth = Integer.parseInt(today.substring(5,7));
        int todayDay = Integer.parseInt(today.substring(8,10));
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ;i < terms.length; i++){
            String[] term = terms[i].split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }

        for(int i = 0 ;i < privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            String data = privacy[0];
            int yyyy = Integer.parseInt(data.substring(0,4));
            int mm = Integer.parseInt(data.substring(5,7));
            int dd = Integer.parseInt(data.substring(8,10)) -1 ;

            String code = privacy[1];
            int month = map.get(code);

            int plusMonth = mm + month;
            while(plusMonth > 12){
                plusMonth = getMon(plusMonth);
                yyyy++;
            }

            if(todayYYYY > yyyy){
                list.add(i);
            }else if(todayYYYY == yyyy){
                if(todayMonth > plusMonth){
                    list.add(i);
                }else if(todayMonth == plusMonth){
                    if(todayDay > dd){
                        list.add(i);
                    }
                }
            }


        }
        answer = new int[list.size()];
        for(int i = 0 ;i < list.size(); i++){
            answer[i] = list.get(i)+1;

        }

        return answer;
    }

    int getMon(int mm){
       int mmNew = 0;
       mmNew = mm - 12;

        return mmNew;
    }




}