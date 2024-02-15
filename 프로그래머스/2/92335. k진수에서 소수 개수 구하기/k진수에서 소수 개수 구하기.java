class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = "";
        num = Integer.toString(n, k);
        String[] arr = num.split("0");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("") || arr[i].equals("1")) continue;
            long b = Long.parseLong(arr[i]);

            if (isPrime(b)) {
                answer++;
            }
        }


        return answer;
    }

    boolean isPrime(long b) {
        for (int j = 2; j <= (int) Math.sqrt(b); j++) {
            if (b % j == 0) return false;
        }
        return true;
    }
}