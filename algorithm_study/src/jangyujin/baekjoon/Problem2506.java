package jangyujin.baekjoon;
/**
 * OX 문제로 만들어진 시험에서 연속적으로 답을 맞히는 경우에는 가산점을 주기 위해서 다음과 같이 점수 계산을 하기로 하였다.
 */
import java.util.Scanner;

public class Problem2506 {
	public static void main(String[] args) {
		// 문제의 개수 입력받음
		Scanner keyboard = new Scanner(System.in);
		int index = 0;
		index = keyboard.nextInt();
		// 채점 결과 입력받기
		int[] result = new int[index];
		for(int i = 0; i < index; i++) {
			result[i] = keyboard.nextInt();
		}
		
		// 점수 계산
		int score = 0;
		int plus = 1;
		for(int i = 0; i < index; i++) {
			if(result[i] == 1) {
				if(i > 0 && result[i-1] == 1) {
					plus++; // 연속으로 맞으면 1씩 증가
				}
				score += plus;
			}
			if(result[i] == 0) {
				plus = 1;
			}
		}
		System.out.println(score);
	}
}
