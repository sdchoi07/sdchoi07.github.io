class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left )+1];
        int cnt = 0;


        int x1 = (int)(left/n);
        int y1 = (int)(left%n);
        int x2 = (int)(right/n);
        int y2 = (int)(right%n);
        int i =0;
        int num1 = (int)((left / n) + 1);
        int num2 = (int)((left % n) + 1);
        answer[i++] = Math.max(num1,num2);
        while(true) {
            if(x1 == x2 && y1 == y2){
                break;
            }



            y1++;
            left++;
            if(y1 % n == 0){
                y1=0;
                x1++;
            }
            num1 = (int)((left / n) + 1);
            num2 = (int)((left % n) + 1);
            
            answer[i++] = Math.max(num1,num2);

        }

        return answer;
    }
}