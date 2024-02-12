import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        String str = "";
        LinkedList<String> cache = new LinkedList<>();
        if(cacheSize == 0) {
            answer = cities.length * 5;
        } else {
            for(String city : cities) {
            // 도시 이름을 전부 소문자로 변경 중복 방지
            str = city.toLowerCase();
            // cacheSize 만큼 데이터가 없다면 cache에 도시 추가 answer += 5
            if(cache.size() < cacheSize) {
                if(cache.indexOf(str) != -1) {
                    cache.remove(str);
                    cache.add(str);
                    answer += 1;
                } else {
                    cache.add(str);
                    answer += 5;
                }
            } else {
                // 캐시에 도시가 존재 유무
                if(cache.indexOf(str) != -1) {
                    cache.remove(str);
                    cache.add(str);
                    answer += 1;
                } else {
                    cache.remove();
                    cache.add(str);
                    answer += 5;
                }
            }
        }
        }


        return answer;
    }
}
