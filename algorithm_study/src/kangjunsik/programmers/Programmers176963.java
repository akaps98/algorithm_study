package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 * 추억 점수
 */

import java.util.HashMap;

public class Programmers176963 {
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> namePoints = new HashMap<>();
        
        for(int i = 0; i < name.length; i++) {
            namePoints.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        
        for(int i = 0; i < photo.length; i++) {
            for(String eachName: photo[i]) {
                if(namePoints.containsKey(eachName)) {
                   answer[i] += namePoints.get(eachName);
                }
            }
        }
        
        return answer;
    }
}
