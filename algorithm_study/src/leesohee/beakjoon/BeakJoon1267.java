package leesohee.beakjoon;

import java.util.Scanner;

/**
 * 핸드폰 요금
 */
public class BeakJoon1267 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt(); // 입력받을 문제 수
        int Y = 0; // 영식 요금제
        int M = 0; // 민식 요금제

        for (int i = 0; i < input; i++){
            int newInput = sc.nextInt();
            Y += (newInput / 30 + 1 ) * 10;
            M += (newInput / 60 + 1 ) * 15;
        }

        if(Y > M) {
            System.out.println("M " + M); // 민식 요금제가 더 싸니 민식 요금제 출력
        }
        else if (Y < M ) {
            System.out.println("Y " + Y); // 민식 요금제가 더 싸니 민식 요금제 출력
        }
        else {
            System.out.println("Y M " + M);
        }
    }
}
