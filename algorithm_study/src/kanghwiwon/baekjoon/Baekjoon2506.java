package kanghwiwon.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 점수계산
 */
public class Baekjoon2506 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		int quizAmount = keyboard.nextInt(); // 문제의 개수 입력값 저장
		int result = 0; // 맞음or틀림 결과 초기값 설정
		List<Integer> resultArray = new ArrayList<>(); // 결과값 담을 리스트 생성

		for (int i = 0; i < quizAmount; i++) {
			result = keyboard.nextInt(); // 0,1 문제의 개수 만큼 입력
			resultArray.add(result);
			// System.out.println(resultArray);
		}

		// 점수계산 프로세스
		// 두 번째 문제는 2점, 세 번째 문제는 3점, ..., K번째 문제는 K점
		int finalScore = 0; // 최종스코어 초기값 설정
		int bonus = 0; // 보너스점수 초기값 설정
		
        for (int i = 0; i < resultArray.size(); i++) {
            // 아이템의 값이 1일 경우, 보너스 점수 증가
            if (resultArray.get(i) == 1) {
                bonus++; // 연속으로 맞춘 문제 수 증가
                finalScore += bonus; // 최종 스코어에 보너스 추가
            } else {
                // 아이템이 값이 0일 경우, 보너스 초기화
                bonus = 0;
            }
        }
		
		System.out.println(finalScore);

	}

}
