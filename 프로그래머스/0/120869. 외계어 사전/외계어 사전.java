class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        for(String sp : dic) {
        	int cnt = 0;
        	for(int j = 0 ;j < spell.length; j++) {
        		if(sp.contains(spell[j])) {
        			cnt++;
        		}
        	}
        	answer = spell.length == cnt ? 1 : 2;
        	if(cnt == spell.length )break;
        }
        return answer;
    }
}