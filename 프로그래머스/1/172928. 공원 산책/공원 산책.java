class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        for(int i = 0; i < park.length; i++){
            for(int j= 0 ;j <park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        for(int i = 0 ;i < routes.length; i++){
            String[] route = routes[i].split(" ");
            String way = route[0];
            int num = Integer.parseInt(route[1]);
            if(way.equals("E")){
                answer = wayE(num, park, answer);
            }else if(way.equals("W")){
                answer = wayW(num,park,answer);
            }else if(way.equals("S")){
                answer = wayS(num,park,answer);
            }else{
                answer = wayN(num,park,answer);
            }


        }
        return answer;
    }
    int[] wayE(int num, String[] park, int[] start){
        int a = start[1];
        for(int j = 0 ;j < num; j++){

            if(start[1] + 1 < park[start[0]].length()){
                char chk = park[start[0]].charAt(start[1] +1);
                if(chk == 'X'){
                    start[1] = a;
                    return start;
                }else{
                    start[1] +=1;
                }
            }else{
                start[1] = a;
                return start;
            }

        }

        return start;
    }

    int[] wayW(int num, String[] park, int[] start){
        int a = start[1];
        for(int j = 0 ;j < num; j++){

                if(start[1] - 1 >= 0){
                    char chk = park[start[0]].charAt(start[1]-1);
                    if(chk == 'X'){
                        start[1] = a;
                        return start;
                    }else{
                        start[1] -=1;
                    }
                }else {
                    start[1] = a;
                    return start;
                }

        }

        return start;
    }

    int[] wayS(int num, String[] park, int[] start){
        int a = start[0];
        for(int j = 0 ;j < num; j++){

                if(start[0] + 1 < park.length){
                    char chk = park[start[0]+1].charAt(start[1]);
                    if(chk == 'X'){
                        start[0] = a;

                        return start;
                    }else{

                        start[0] +=1;
                    }

            }else {
                    start[0] = a;
                    return start;
                }
        }

        return start;
    }

    int[] wayN(int num, String[] park, int[] start){
        int a = start[0];
        for(int j = 0 ;j < num; j++){

                if(start[0] - 1 >= 0){
                    char chk = park[start[0]-1].charAt(start[1]);
                    if(chk == 'X'){
                        start[0] = a;
                        return start;
                    }else{
                        start[0] -=1;
                    }
                }else {
                    start[0] = a;
                    return start;
                }

        }
        return start;
    }
}