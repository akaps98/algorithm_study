package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/76501
 * 음양 더하기
 */

public class Programmers76501 {
    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};

        System.out.println(solution(absolutes, signs));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i]) { // true일 경우 positive
                answer += absolutes[i];
            } else { // false일 경우 negative
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
