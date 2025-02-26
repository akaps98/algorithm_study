package leesohee.beakjoon;

import java.util.Scanner;

/**
 * 점수계산
 */
public class BeakJoon2506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt(); // 입력받을 문제 수
        int totalScore = 0; // 총 점수
        int countScore = 0; // 연속 점수 계산

        // 입력받은 문제 수만큼 반복
        for (int i = 0; i < input; i++) {
            int newInput = sc.nextInt();

            if (newInput == 1) { // 맞힌 경우
                countScore++;
                totalScore += countScore;
            } else { // 틀린 경우
                countScore = 0;
            }
        }

        System.out.print(totalScore); // 최종 점수 출력
    }
}
