import java.util.*;
class Solution {
    static HashMap<String, Integer> map;
    public String[] solution(String[] players, String[] callings) {
        int sizeP = players.length;
        String[] answer = Arrays.copyOf(players, sizeP);
        map = new HashMap<>();
       //이름 별로 순위를 map에 저장
        for(int i = 0; i < sizeP; i++){
            map.put(players[i], i);
        }
        int sizeC = callings.length;
        for(int i = 0; i < sizeC; i++){
            int curRank = map.get(callings[i]);
          //앞 순위 사람 이름 가져와서 map과 정답 배열의 순위 변경
            String frontPlayer = answer[curRank-1];
            map.put(callings[i], curRank-1);
            map.put(frontPlayer, curRank);
            answer[curRank] = frontPlayer;
            answer[curRank-1] = callings[i];
        }
        return answer;
    }
}
