class Solution {
   public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] phone = {{1,2,3}
                        ,{4,5,6}
                        ,{7,8,9}
                        ,{-1,0,-2}};
        int[] left ={3,0};
        int[] right = {3,2};

        for(int i = 0 ;i < numbers.length;i++){
            int key = numbers[i];
            for(int j = 0 ; j<phone.length; j++){
                for(int k = 0 ;k<phone[j].length; k++){
                    int number = phone[j][k];
                    if(key == number){
                        int a = Math.abs((left[0] - j)) + Math.abs((left[1] - k));
                        int b = Math.abs((right[0] - j)) + Math.abs((right[1] - k));
                        if(number == 3 || number == 6 || number == 9){
                            answer+="R";
                            right[0] = j;
                            right[1] = k;
                        }else if(number == 1 || number == 4 || number == 7){
                            answer+="L";
                            left[0] = j;
                            left[1] = k;
                        }else{
                            if(a>b){
                                answer+="R";
                                right[0] = j;
                                right[1] = k;
                            }else if(a<b){
                                answer+="L";
                                left[0] = j;
                                left[1] = k;
                            }else {
                                if(hand.equals("right")){
                                    answer+="R";
                                    right[0] = j;
                                    right[1] = k;
                                }else{
                                    answer+="L";
                                    left[0] = j;
                                    left[1] = k;
                                }
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}