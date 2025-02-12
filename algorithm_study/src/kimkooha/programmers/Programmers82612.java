package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/82612
 * <p>
 * <p>
 * 놀이기구의 이용 금액은 30 (= 3+6+9+12) 이 되어 10만큼 부족하므로 10을 return
 *  금액이 부족하지 않으면 0을 return
 */
public class Programmers82612 {
    class Solution {
        public long solution(int price, int money, int count) {
            long answer;
            long result = 0;

            for (long i = 1; i <= count; i++) {     // result 변수에 price * i 값을 더한다
                result += price * i;
            }

            if (money > result) return 0;           // 보유 money > 이용금액(result) = return 0;

            answer = Math.abs(result - money);      // Math.abs -> 음수 값 나와도 절대값을 반환


            return answer;
        }
    }
}
