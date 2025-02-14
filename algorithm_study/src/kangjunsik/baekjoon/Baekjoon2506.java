package kangjunsik.baekjoon;

import java.io.*;

public class Baekjoon2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 문제 개수 입력
        String[] input = br.readLine().split(" "); // 공백으로 분리된 숫자 입력

        int score = 0; // 최종 결과 값
        int point = 1; // 연속해서 맞췄을 경우의 값

//        for (String s : input) { // for-each 문도 사용 가능하나, 문제에서 N이라는 변수를 줬기에 N을 사용한 for문을 utilize
//            int num = Integer.parseInt(s);
//            if (num == 0) {
//                point = 1;
//            } else {
//                score += num * point;
//                point++;
//            }
//        }

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(input[i]); // num값은 0이나 1일 경우만임
            if (num == 0) { // num이 0 이면 틀린 경우이기에 point값을 1로 초기화
                point = 1;
            } else { 
                score += num * point; // num은 1 이기에 point만큼의 값을 곱해주면 정상적인 값이 나옴. 그 뒤에 score에 더해줌
                point++; // 다음 반복에서 연속으로 맞췄을 경우를 대비해 ++
            }
        }

        System.out.println(score);
    }
}
