package programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/77884
 * left와 right가 매개변수로 주어지고, 약수의 갯수만큼 홀수면 - 짝수면 +
 * ex) left=13, 약수 : 1, 13, 짝수= +13,     right=16, 약수 : 1,2,4,8,16, -> 홀수= -16
 */
public class Programmers12910 {
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;

            for (int i = left; i <= right; i++) {   // left 부터 right 까지 루프
                if (findDivisor(i)) {               // 홀수라면
                    answer -= i;                    // - i
                    continue;
                }
                answer += i;                        // 짝수라면 +i
            }
            return answer;
        }

        // 짝수인지 홀수 인지 판별. 홀수 - true, 짝수 - false;
        private boolean findDivisor(int value) {
            int divisorCount = 0;
            for (int i = 1; i <= value; i++) {
                if (value % i == 0) {       // value 값을 i로 나눴을 때, 딱 떨어지는 수(약수) 라면?
                    divisorCount++;         // count 증가
                }
            }
            return divisorCount % 2 != 0;   // 적합한 boolean 반환
        }
    }
}
