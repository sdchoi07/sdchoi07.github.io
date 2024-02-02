class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int x = 0;
        int y = 0;
        int minX = 0;
        int minY = 0;
        for(int i = 0 ;i < wallpaper.length;i++){
            for(int j = 0 ;j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    x = i;
                    y = j;
                }
                if(minX < x){
                    minX = x;
                }
                if(minY < y){
                    minY = y;
                }
            }
        }
        answer[2] = minX+1;
        answer[3] = minY+1;
        int maxX = 100;
        int maxY = 100;
        for(int i = wallpaper.length-1 ;i >=0;i--){
            for(int j = wallpaper[i].length()-1 ;j >=0; j--){
                if(wallpaper[i].charAt(j) == '#'){
                    x = i;
                    y = j;
                }
                if(maxX > x){
                    maxX = x;
                }
                if(maxY > y){
                    maxY = y;
                }
            }
        }
        answer[0] = maxX;
        answer[1] = maxY;
        return answer;
    }
}