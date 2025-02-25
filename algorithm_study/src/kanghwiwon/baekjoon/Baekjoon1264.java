package kanghwiwon.baekjoon;

import java.util.Scanner;

/**
 * 영문 문장을 입력받아 모음의 개수를 세는 프로그램을 작성하시오. 모음은 'a', 'e', 'i', 'o', 'u'이며 대문자 또는 소문자이다.
 * 입력은 여러 개의 테스트 케이스로 이루어져 있으며, 
 * 각 줄마다 영어 대소문자, ',', '.', '!', '?', 공백으로 이루어진 문장이 주어진다. 각 줄은 최대 255글자로 이루어져 있다.
 * 입력의 끝에는 한 줄에 '#' 한 글자만이 주어진다.
 */
public class Baekjoon1264 {
	
    /**
     * 모음 여부 확인 메서드
     * @param c userInput을 char배열로 분해한 후 toLowerCase()가 적용된 단일 char
     * @return aeiou 존재 시 true / else false
     */
    public static boolean isVowel(char c) {
    	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    	// aeiou가 존재하면 true
    }
	
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        String userInput = null; // 유저 입력 초기값 설정
        String inputLowerString = null; // 유저 입력 소문자 초기값 설정
        int vowelCount = 0; // 모음 수 초기값 설정

        while(true) {
        	vowelCount = 0; // 모음 수 초기화
        	userInput = keyboard.nextLine(); // 입력값 세이브
        	
        	// #입력시 프로그램 종료 종료
        	if(userInput.equals("#")) {
        		break;
        	}
        	
        	inputLowerString = userInput.toLowerCase(); // 검사 위해 소문자로 전환
        	char[] inputCharArray = inputLowerString.toCharArray(); // char 배열로 전환
        	
            for(char c : inputCharArray) {
            	// 모음 여부 확인 메서드 생성
            	if(isVowel(c)) {
            		vowelCount++;
            	}
            }
            System.out.println(vowelCount); // 모음 수 출력
        }
    }
	
}
