package choiyejin.programmers;

public class programmers388351 {
	public int solution(long num) {
		int answer = 0;
		//조건 : 입력받은 값이 1이면 0출력
		if (num == 1) {
			return 0;
		}
		//1이 될 때까지 반복해야해서 while문 사용
		while (true) {
			// 짝수일 때 2나누기
			if (num % 2 == 0) {
				num /= 2;
			// 홀수 일 때 3곱하고 1 더하기
			} else {

				num *= 3;
				num += 1;

			}
			//얼마나 했는지 카운팅하기
			answer++;
			//num 1이 되면 카운팅한 수 리턴
			if (num == 1) {
				return answer;
		    //만약에 500이 되도록 1이 되지 않으면 -1 리턴
			} else if (answer == 500 && num != 1) {
				return -1;
			}

		}

	}
}
