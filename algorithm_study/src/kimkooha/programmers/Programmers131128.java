package programmers;

import java.util.Collections;
import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131128
 * <p>
 * 두 정수 X, Y에서 공통으로 나타나는 숫자를 사용해 만들 수 있는 가장 큰 정수를 문자열로 반환합니다. 짝꿍이 없으면 -1, 0으로만 구성되면 0을 반환합니다.
 */
public class Programmers131128 {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        String repeatDigit = getRepeatedDigit(countDigits(X), countDigits(Y));

        // 빈 문자열 이라면 -1 반환
        if (repeatDigit.isEmpty()) {
            return "-1";
        }

        String[] digitArr = repeatDigit.split("");  // 내림차순 정렬 하기 위해 배열로 변환
        Arrays.sort(digitArr, Collections.reverseOrder()); // 내림차순 정렬

        // 숫자가 0으로만 구성된 경우 0 반환
        if (repeatDigit.matches("0+")) {
            return "0";
        }

        for (String value : digitArr) { // for-each로 answer 에 값 더함
            answer.append(value);
        }

        return answer.toString();
    }

    // x 와 y에서 공통 으로 나타나는 숫자를 추출
    private String getRepeatedDigit(int[] xArr, int[] yArr) {
        StringBuilder value = new StringBuilder();

        for (int i = 0; i < xArr.length; i++) {     //0~9까지 반복
            int count = Math.min(xArr[i], yArr[i]);     // x와 y에서 공통으로 존재 하는 개수 중 최소 값

            //공통 숫자가 1개 이상일 때 추가
            if (count > 0) {
                value.append((i + "").repeat(count)); // 현재 숫자(i)를 count 만큼 반복 하여 value에 추가
            }
        }
        return value.toString();
    }

    // 숫자를 세어 해당 위치에 인덱스 값을 증가 시키는 메소드
    private int[] countDigits(String value) {
        int[] arr = new int[10];                // 숫자는 0~9 만 들어 오니까 크기 10 배열 생성

        for (String str : value.split("")) {
            arr[Integer.parseInt(str)]++;               // 해당 인덱스 값 1증가  (ex. str = 2 라면, arr[2]++ )
        }

        return arr;
    }
}
