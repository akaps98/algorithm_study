package programmers;

/**
 *
 *https://school.programmers.co.kr/learn/courses/30/lessons/12943
 *임의의 자연수 n에 대해, `짝수면 2로 나누고 홀수면 3을 곱한 후 1을 더하는 과정을 1이 될 때 까지 반복. 횟수가 500 이상 이면 -1
 */
public class Programmers12943 {
    public int solution(int num) {
        int answer = 0;
        long value = num;       // 오버플로우로 인해 long 변경

        while (value != 1 && answer < 500) {    // value가 1이 될 때까지, 반복 횟수가 500 회 넘지 않도록
            if (value % 2 == 0) {               // 짝수 라면?
                value /= 2;                     // 나누기 2
            } else if (value % 2 != 0) {        // 홀수 라면?
                value = value * 3 + 1;          // *3 +1
            }
            answer++;
        }

        if (answer >= 500) {
            return -1;              // 500번 반복 해도 1이 안되면 -1 반환
        }

        return answer;
    }
}
