package kimkooha.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12935
 * 제일 작은 수 제거하기
 *
 * 주어진 배열에서 가장 작은 값을 제거한 새로운 배열을 반환 하는 문제.
 * 만약 배열의 길이가 1이면, [-1]을 반환 한다.
 */
public class Programmers12935 {
    public int[] solution(int[] arr) {
        int[] answer = getArray(arr);           // 결과 배열 생성 (arr.length - 1 크기)
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == getMinIndex(arr)) {        // i 가 가장 작은 수 라면   (i == getMinIndex(arr))
                continue;                       // 밑의 코드는 실행 하지 않고, 해당 값은 건너 뛴다.    (continue)
            }

            answer[count] = arr[i];             // 가장 작은 수를 제외한 값들을 answer 배열에 저장
            count++;
        }

        return answer;
    }

    // 배열 길이 검증 + 적절한 결과 배열 생성
    private int[] getArray(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};               // 배열 길이가 1이면 [-1] 반환
        }
        return new int[arr.length - 1];         // 새로운 배열 생성 (가장 작은 수를 제외한 크기)
    }

    // 배열에서 가장 작은 값의 인덱스를 찾는다.
    private int getMinIndex(int[] arr) {
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[idx]) {            // 현재 값이 최소 값보다 작으면
                idx = i;                        // 최소 값의 인덱스 갱신
            }
        }
        return idx;
    }


}

