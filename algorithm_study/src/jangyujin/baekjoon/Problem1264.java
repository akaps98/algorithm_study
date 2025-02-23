package jangyujin.baekjoon;

import java.util.ArrayList;
import java.util.List;
/**
 * 영문 문장을 입력받아 모음의 개수를 세는 프로그램을 작성하시오. 모음은 'a', 'e', 'i', 'o', 'u'이며 대문자 또는 소문자이다.
 */
import java.util.Scanner;

public class Problem1264 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		// 입력 저장할 List 선언
		List<String> input = new ArrayList<>();
		String str;

		while (true) {
			// 문장 입력받기
			str = keyboard.nextLine();

			// # 입력시 문장 입력 종료
			if (str.equals("#")) {
				break;
			}

			input.add(str);
		}

		// 구분자가 여러개인 경우??
		// split 메소드는 구분자를 정규식을 통해서 or 연산을 수행한다!
		// 정규식에서 "."(임의의 한 문자)과 "+"(앞 문자가 하나이상)는 단순한 문자열로 인식하기 위해 escape \\를 추가한다!

		int counter = 0;

		for (int i = 0; i < input.size(); i++) {
			String[] inputLetter = input.get(i).split("[,.!? ]");

			for (int j = 0; j < inputLetter.length; j++) {
				// 문장의 시작, 대문자를 소문자로 바꿔야한다!
				inputLetter[j] = inputLetter[j].toLowerCase();
				// 한 단어씩 모음 검사 => 한 글자씩 검사! (String -> Char)
				for (int k = 0; k < inputLetter[j].length(); k++) {
					char c = inputLetter[j].charAt(k);

					if ((c == 'a') || (c == 'e') || (c == 'i') ||
					(c == 'o') || (c == 'u')) {
						counter++;
					}
				}
			}
			System.out.println(counter);
			counter = 0;
		}

	}
}
