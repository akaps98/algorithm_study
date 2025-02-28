package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748 
 * k번째수
 * 어려웠던 부분: 숫자가 두자리수 일시, 문자열로 편집하기 힘듬. split 사용시에! 
 * ex) [5,8,9] -> 589로 변환해서 사용하면 끝인데, [10,7,22] -> 10722로 변환되어 계산하기 힘들다.
 */

import java.util.ArrayList;
import java.util.Collections;

class Programmers42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int startIdx = commands[i][0]; // 각 array 자를 시작 인덱스
            int endIdx = commands[i][1]; // 각 array 자를 끝 인덱스
            int answerIdx = commands[i][2]; // 숫자를 구할 지정 인덱스
            
            int[] tempArr = new int[array.length]; // 매 반복마다 초기화되어야함
            
            System.arraycopy(array, 0, tempArr, 0, array.length);
            
            ArrayList<Integer> answerArr = new ArrayList<>();
            
            boolean isContain = false; // true일 시 answerArr에 넣기
            
            if(startIdx == endIdx) { // idx가 같을 시엔 내 알고리즘에서는 숫자가 들어갈 수가 없다. 예외처리부터
                answerArr.add(tempArr[startIdx - 1]);
            } else { // 같지 않으면 최소 두개 이상의 숫자가 들어감
                for(int j = 0; j < tempArr.length; j++) {
                    if(j == startIdx - 1) { // startIdx - 1이랑 같으면 isContain true로 변경
                        isContain = true;
                    } else if (j == endIdx) { // endIdx랑 같으면
                        isContain = false; // false로 변경 후 for-loop 종료; 이 이상 숫자를 넣을 필요가 없다
                        break;
                    }
                    
                    if(isContain) { // isContain이 true일동안 모든 숫자를 삽입
                        answerArr.add(tempArr[j]);
                    }
                }   
            }
            
            Collections.sort(answerArr); // 정렬 후
            
            answer[i] = answerArr.get(answerIdx - 1); // 정답 담기
        }
        
        return answer;
    }
}