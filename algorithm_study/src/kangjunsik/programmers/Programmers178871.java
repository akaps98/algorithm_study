package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 * 달리기 경주
 */

import java.util.HashMap;

public class Programmers178871 {
	public String[] solution(String[] players, String[] callings) {
        // for(int i = 0; i < callings.length; i++) {
        //     for(int j = 0; j < players.length; j++) {
        //         if(players[j].equals(callings[i])) {
        //             String tempPlayer = players[j - 1];
        //             players[j - 1] = players[j];
        //             players[j] = tempPlayer;
        //             break;
        //         }
        //     } 
        // } // 시간초과 뜸 (이중 반복문 사용 불가)
        
        HashMap<String, Integer> playersMap = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            playersMap.put(players[i], i);
        }
        
        for(String calling : callings) {
            int idx = playersMap.get(calling);
            if(idx > 0) {
                String tempPlayer = players[idx - 1];
                players[idx - 1] = players[idx];
                players[idx] = tempPlayer;
                
                playersMap.put(players[idx - 1], idx - 1);
                playersMap.put(players[idx], idx);
            }
        }
        
        String[] answer = players;
        return answer;
    }
}
