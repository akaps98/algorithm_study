package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131128
 * 숫자 짝꿍
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers131128 {
    public static void main(String[] args) {
        System.out.println(solution("100", "203045"));
    }

    public static String solution(String X, String Y) {
        HashMap<Integer, Integer> checkX = new HashMap<>();
        HashMap<Integer, Integer> checkY = new HashMap<>();

        for(char c : X.toCharArray()) {
            int digit = Character.getNumericValue(c);
            checkX.put(digit, checkX.getOrDefault(digit, 0) + 1);
        }

        for(char c : Y.toCharArray()) {
            int digit = Character.getNumericValue(c);
            checkY.put(digit, checkY.getOrDefault(digit, 0) + 1);
        }

        List<Integer> sameNumber = new ArrayList<>();
        for(Map.Entry<Integer, Integer> xEntry : checkX.entrySet()) {
            if (checkY.containsKey(xEntry.getKey())) { // 중복되는 숫자 찾으면
                int dupVal = checkY.get(xEntry.getKey());
                int duplicated = Math.min(xEntry.getValue(), dupVal); // 몇 번 중복되었는가?

                for(int i = 0; i < duplicated; i++) {
                    sameNumber.add(xEntry.getKey()); // 중복된 숫자들을 중복된 만큼 sameNumber에 넣어줌
                }
            }
        }

        sameNumber.sort(Collections.reverseOrder()); // 내림차순 정렬

        String answer;

        if(sameNumber.isEmpty()) { // 중복된 숫자가 없다면
            answer = "-1"; // -1 리턴
            return answer;
        }

        StringBuilder sb = new StringBuilder();

        for(int num : sameNumber) {
            sb.append(num);
        }

        answer = sb.toString();

        if (!answer.startsWith("0")) { // 숫자가 0으로 시작하면 그건 모든 자리의 숫자가 0이다(이미 정렬 해놨음)
            return answer;
        }

        answer = "0"; // for-loop가 종료됐는데 리턴 안했다면, 모든 숫자가 0이라는 소리. 0을 return 해야한다
        return answer;
    }
}
