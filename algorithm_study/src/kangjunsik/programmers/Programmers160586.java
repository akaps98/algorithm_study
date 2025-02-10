package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
 * 대충 만든 자판
 */

import java.util.HashMap;
import java.util.Arrays;

public class Programmers160586 {
	public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length]; // 최종 결과를 담을 값.
        HashMap<Character, Integer> keymapSetting = new HashMap<>(); // 각 targets의 letter를 누르는 최소값을 저장할 HashMap -> {key, value} 형태로 저장됨; key는 letter(A, B, C, D, ...), value는 그 letter를 누른 최소값

        for(String key: keymap) { // 하나씩 돌린다 - 여기서는 ABACD, BCEFD 총 두번
            for(int i = 0; i < key.length(); i++) {
                char keymapLetter = key.charAt(i); // 각 keymap에 있는 letter

                if(keymapSetting.containsKey(keymapLetter)) { // 만약 map에 ch(각 keymap에 있는 letter)가 있다면 최소값이 될 수도 있으므로 비교 후 갱신해야함. 비교 하지 않으면 최소값이 아닌 수를 넣어버리는 불상사기 생길수도 있다.
                    if(keymapSetting.get(keymapLetter) > i) { // 현재 map에 저장된 key(letter)의 value(자판을 누른 횟수) 비교
                        keymapSetting.replace(keymapLetter, i + 1); // j는 0부터 시작, 자판을 클릭한 횟수를 계산하기 때문에 +1 해줘야 정확한 값이 됨(누른 횟수는 1부터 시작). 문자열을 key로, 클릭한 횟수를 j + 1로 value 저장.
                    }
                } else { // 없다면? 처음 나온 값이라서 일단 저장
                    keymapSetting.put(keymapLetter, i + 1);
                }
            }
        }

        for(int i = 0; i < targets.length; i++) { // 각 letter들의 자판 누르는 최소값을 구했으니, 이제 answer을 구할 차례
            int sum = 0; // 초기값 지정 (for-loop가 돌 때마다 0으로 초기화된다) why? 각 target마다의 자판 누르는 값을 구해야 하기 때문!
            for(int j = 0; j < targets[i].length(); j++) { // 하나씩 돌린다. 여기서는 ABCD, AABB 총 두번
                char targetLetter = targets[i].charAt(j); // 각 target의 letter 하나씩 찾는다

                if(keymapSetting.containsKey(targetLetter)) { // containsKey로 key값인 letter가 있는지 없는지부터 검색. 만약 HashMap에 있다면 입력이 가능하다.
                    sum += keymapSetting.get(targetLetter); // key의 value를 가져와 처음에 지정해둔 sum에 저장
                } else { // HashMap에 없다면? 입력할 수 없는 경우이다.
                    sum = -1; // sum을 -1로 바꾸고 (입력할 수 없는 경우에는 -1을 출력해야함)
                    break; // 그 즉시 for-loop escaping
                }
            }
            answer[i] = sum; // 각 결과 값을 저장.
        }

        return answer;
    }
}
