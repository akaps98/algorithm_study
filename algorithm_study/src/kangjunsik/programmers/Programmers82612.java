package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/82612
 * 부족한 금액 계산하기
 */

public class Programmers82612 {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 1));
    }

    public static long solution(int price, int money, int count) {
        long tempPrice = price; // 각 for-loop 마다 임시로 저장해 둘 값

        long sum = price; // count 1은 여기서 시작

        for(int i = 0; i < count - 1; i++) { // count 2부터 시작
            tempPrice += price; // tempPrice에 price를 추가해 주고
            sum += tempPrice; // sum에 tempPrice를 추가해 준다
        }

        if(sum < money) { // 돈이 부족하지 않다
            return 0;
        }

        return sum - money; // 돈이 부족하므로 sum에서 money를 빼줌
    }
}
