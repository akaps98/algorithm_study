package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142086
 * 가장 가까운 같은 글자
 */

import java.util.Arrays;

public class Programmers142086 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("abca")));
    }

    public static int[] solution(String s) {
        StringBuilder appendString = new StringBuilder(); // string index 비교를 위함
        int[] answer = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            if(appendString.toString().indexOf(s.charAt(i)) == -1) { // 처음 나오는 letter
                answer[i] = -1; // 방금 위에서 체크한 사항. 처음 나온 letter니 -1을 넣는다
                appendString.append(s.charAt(i)); // 추후 필요한 비교 문자열에도 추가해준다, 여긴 더 비교할 것이 없으니(처음 나온 letter) 다음 loop로
            } else { // 처음 나오는 문자열이 아님, 즉 비교 가능
//                appendString.append(s.charAt(i)); // 여기서는 먼저 추가x, 비교를 위해 비교 후 추가해야 한다
                char tempLetter = s.charAt(i); // 현재 비교할 letter 미리 저장
                answer[i] = i - appendString.toString().lastIndexOf(tempLetter); // 각 자릿수 비교하여 그 차이만큼 빼준다. appendString에는 현재 letter를 아직 추가하지 않아서 제대로 된 비교 가능.
                appendString.append(s.charAt(i)); // 비교 및 연산이 끝난 후에 추가해준다.
            }
        }

        return answer;
    }
}
