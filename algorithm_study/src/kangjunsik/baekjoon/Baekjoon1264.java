package kangjunsik.baekjoon;

/**
 * https://www.acmicpc.net/problem/1264
 * 모음의 갯수
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon1264 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        while (true) {
            String word = sc.nextLine();
            if (word.equals("#")) { // # 입력 시 중단
                break;
            }
            words.add(word); // 입력한 문자 words에 추가
        }

        // 모음 개수 계산 하고 출력
        for (String word : words) {
            System.out.println(countVowels(word));
        }
    }

    // 모음 개수를 세는 메소드
    private static int countVowels(String word) {
        int count = 0;
        String lowerWord = word.toLowerCase(); // 소문자로 변환하여 비교

        for (char ch : lowerWord.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) { // 만약 word에 모음이 어느 idx에라도 있다면
                count++;
            }
        }

        return count;
    }
}
