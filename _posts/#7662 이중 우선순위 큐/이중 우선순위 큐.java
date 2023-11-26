
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ;i < t ; i++) {
			int n = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(); //트리맵 자료구조에서 lastKey, Firstkey 함수가있어 사용 
			for(int j = 0 ;j < n; j++) {
				String sss = br.readLine();
				String[] sArr = sss.split(" ");
				if(sArr[0].equals("I")) { //"I" 일경우 ,  treeMap 에 저장하는데, 중복값이 들어갈수 있으므로 getOrDefault 사용
					int num = Integer.parseInt(sArr[1]);
					map.put(num, map.getOrDefault(num, 0)+1);
				}else { //"D"일경우
					if(map.size() == 0)continue; //트리맵에 비어있을경우 넘어감
					
					int num = Integer.parseInt(sArr[1]); 
					int key = num ==1? map.lastKey() : map.firstKey(); //1일경우에는 최댓값, -1일경우에는 최솟값으로 key에 저장
					int cnt = map.get(key); // key값으로 해당 map의 values 값 저장
					
					if(cnt == 1) { // 1일경우 트리맵에서 삭제 
						map.remove(key); 
					}else { // 중복값이 있다는 의미로 갯수 줄이기
						map.put(key, cnt-1);
					}
				}
			}
			if (map.size() == 0) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}

		System.out.println(sb.toString());
		
	}
}