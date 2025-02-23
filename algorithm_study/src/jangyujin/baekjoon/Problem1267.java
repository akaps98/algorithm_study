package jangyujin.baekjoon;
/**
 * 핸드폰 요금
 */
import java.util.Scanner;
public class Problem1267 {
	public static void main(String[] args) {
		// Y 영식 요금제: 30초당 10원 
		// M 민식 요금제 60초당 15원
		
		// 통화 수
		int call = 0;
		Scanner keyboard = new Scanner(System.in);
		call = keyboard.nextInt();
		
		// 통화 시간
		int[] time = new int[call];
		for(int i=0; i < call; i++) {
			time[i] = keyboard.nextInt();
		}
		
		// 더 싼 요금제 출력
		int billY = 0;
		int billM = 0;
		for(int i=0; i < call; i++) {
			int min = time[i] / 60;
			int sec = time[i] % 60;
			
			if(min > 0) {
				// 1분 영식 30, 민식 15 => 초가 0으로 떨어져도 금액 더하기!
				// 2분 영식 60, 민식 45
				billY += min * 20;
				billM += min * 15;
			}
			if(sec >= 30) { // 영식
				billY += 10;
			}
			if(sec >= 0) {
				//영식 0 ~ 29 는 + 20
				//민식 0 ~ 59는 + 30
				billY += 10;
				billM += 15;
				
			}	
		}
		if(billY < billM) {
			System.out.println("Y " + billY);
		}
		else if(billY > billM) {
			System.out.println("M " + billM);
		}
		else {
			System.out.println("Y M " + billY);
		}
	}
}
