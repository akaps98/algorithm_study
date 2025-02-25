package kanghwiwon.baekjoon;

import java.util.Scanner;

/**
 * 동호는 새악대로 T 통신사의 새 핸드폰 옴머나를 샀다. 새악대로 T 통신사는 동호에게 다음 두 가지 요금제 중 하나를 선택하라고 했다.
 * 
 * 영식 요금제 민식 요금제
 * 
 * 영식 요금제는 30초마다 10원씩 청구된다. 이 말은 만약 29초 또는 그 보다 적은 시간 통화를 했으면 10원이 청구된다. 만약
 * 30초부터 59초 사이로 통화를 했으면 20원이 청구된다.
 * 
 * 민식 요금제는 60초마다 15원씩 청구된다. 이 말은 만약 59초 또는 그 보다 적은 시간 통화를 했으면 15원이 청구된다. 만약
 * 60초부터 119초 사이로 통화를 했으면 30원이 청구된다.
 * 
 * 동호가 저번 달에 새악대로 T 통신사를 이용할 때 통화 시간 목록이 주어지면 어느 요금제를 사용 하는 것이 저렴한지 출력하는 프로그램을
 * 작성하시오.
 */
public class Baekjoon1267 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int Y = 0; // 영식 요금제 초기값 설정
		int M = 0; // 민식 요금제 초기값 설정
		int donghoCall = 0; // 동호가 통화한 시간 초기값 설정

		int N = keyboard.nextInt(); // 초기 통화 수 입력값 저장

		// 입력한 N회만큼 통화비 누적
		for (int i = 0; i < N; i++) {
			donghoCall = keyboard.nextInt();

			// 영식 요금제 e.g. 0~29: 10, 30~59: 20 ..
			Y += ((donghoCall / 30) + 1) * 10;
			// 민식 요금제
			M += ((donghoCall / 60) + 1) * 15;
		}

		// 영식이 더 비싼 경우, M(민식)출력
		if (Y > M) {
			System.out.println("M " + M);
		}
		// 민식이 더 비싼 경우, Y(영식)출력
		else if (Y < M) {
			System.out.println("Y " + Y);
		}
		// 그렇지 않은 경우(같은 경우)
		else {
			System.out.println("Y M "+ Y);
		}

	}

}
