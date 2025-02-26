package leesohee.beakjoon;

import java.util.Scanner;

public class BeakJoon1264 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            input = sc.nextLine();
            // 입력이 '#'이면 종료
            if (input.equals("#")) {
                break;
            }

            // 소문자로 변환하여 모음 개수 세기
            int count = 0;
            input = input.toLowerCase();
            for (char ch : input.toCharArray()) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }
            }

            // 결과 출력
            System.out.println(count);
        }
    }
}
