package kangjunsik.baekjoon;

import java.util.*;

public class Baekjoon1267 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt(); // 통화의 갯수
        int Y = 0, M = 0; // 영식 & 민식 요금제

        for(int i = 0; i < N; i++) {
            int call = input.nextInt(); // 통화 시간 입력
            Y += ((call / 30) + 1) * 10; // 30으로 나눈 몫에 1을 더하고 10원 곱함
            M += ((call / 60) + 1) * 15; // 60으로 나눈 몫에 1을 더하고 15원 곱함
        }

        if(Y == M) { // 요금제가 같으면 영식쓰고 민식
            System.out.println("Y M " + Y);
        } else if(Y > M) { // 민식이 더 쌈
            System.out.println("M " + M);
        } else { // 영식이 더 쌈
            System.out.println("Y " + Y);
        }
    }
}