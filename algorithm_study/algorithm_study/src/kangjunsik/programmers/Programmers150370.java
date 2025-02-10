package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/136798
 * 기사단원의 무기
 */

public class Programmers150370 {
    public static void main(String[] args) {
        System.out.println(solution(10, 3, 2));
    }

    public static int solution(int number, int limit, int power) {
        int[] counts = new int[number];

        for(int i = 1; i <= number; i++) {  // 각 숫자 i에 대한 약수 개수 구하기
            for(int j = 1; j * j <= i; j++) { // 시간 복잡도를 줄이기 위해 i의 제곱근 까지만 돌린다
                if (i % j == 0) {  // i의 약수인지 확인
                    counts[i - 1]++; // 맞으면 그 idx에 1씩 증가
                    if (j != i / j) {  // 제곱근이 아니라면 짝이 되는 약수도 추가
                        counts[i - 1]++; // 한번 더 추가
                    }
                }
            }
        }

        int answer = 0;

        for(int count: counts) {
            if(count <= limit) {
                answer += count;
            } else {
                answer += power;
            }
        }

        return answer;
    }
}
