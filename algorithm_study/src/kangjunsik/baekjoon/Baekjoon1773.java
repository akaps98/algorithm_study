package kangjunsik.baekjoon;

/**
 * https://www.acmicpc.net/problem/1773
 * 폭죽쇼
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon1773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 학생의 수
        int C = Integer.parseInt(input[1]); // 폭죽쇼가 끝나는 시간

        ArrayList<Integer> fireworks = new ArrayList<>(); // 학생마다의 폭죽을 터뜨리는 주기

        for(int i = 0; i < N; i++) {
            fireworks.add(Integer.valueOf(br.readLine()));
        }

        int count = 0;

        for(int i = 1; i <= C; i++) { // 폭죽쇼가 끝나는 시간까지 각 초를 계산해야 한다
            for(int j = 0; j < N; j++) { // 각 학생들 순회
                if(i % fireworks.get(j) == 0) { // 나누어 떨어지면 그 초에 폭죽이 터진다
                    count++; // count를 하나 더해주고
                    break; // 다음 학생 폭죽도 터질 때를 대비해 break로 학생 순회 break
                }
            }
        }

        System.out.println(count);
    }
}
