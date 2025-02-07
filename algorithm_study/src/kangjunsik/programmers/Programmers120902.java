package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120902
 * 문자열 계산하기
 */

public class Programmers120902 {
    public static int solution(String my_string) {
        String[] splitString = my_string.split(" "); // 공백으로 나눠 모든 문자 배열화

        int answer = Integer.parseInt(splitString[0]); // 첫 숫자는 미리 저장

        for(int i = 1; i < splitString.length; i++) { // splitString 순회
            if(i == splitString.length - 1) { // 순회 이미 종료. 이 이상 진행할 시 outOfIndex. error exception
                break;
            }
            
            if(i % 2 == 1) { // 배열의 홀수번째 인덱스에 있는 값은 반드시 operator
                String op = splitString[i];

                // operator 값에 따라 계산 진행. 현재 연산자 뒤에 있는 숫자를 원래의 answer 값에 더해주거나 뺀다.
                answer = op.equals("+") ? answer + Integer.parseInt(splitString[i + 1]) : answer - Integer.parseInt(splitString[i + 1]);
            }
        }

        return answer;
    }
}
