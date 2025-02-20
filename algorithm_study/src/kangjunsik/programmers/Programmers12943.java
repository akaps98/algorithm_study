package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12943
 * 콜라츠 추측
 */

public class Programmers12943 {
    public static void main(String[] args) {
        System.out.println(solution(626331));
    }

    public static int solution(int num) {
        if(num == 1) {
            return 0;
        }

        int answer = 0;

        long tempNum = Long.parseLong(String.valueOf(num)); // Integer는 범위 초과, long으로 변환

        while(tempNum != 1) { // num이 1이 될때까지 돌린다
            if(tempNum % 2 == 0) {
                tempNum /= 2;
            } else {
                tempNum = tempNum * 3 + 1;
            }

            answer++; // 연산 반복 값

            if(answer > 500) { // 500 이상이면 끝
                return -1;
            }
        }

        return answer; // 정상 결과시 answer 리턴
    }
}
