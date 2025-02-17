package programmers;

/**
 *https://school.programmers.co.kr/learn/courses/30/lessons/388351
 *
 *직원이 설정한 출근 희망 시각 + 10분 이내에 출근한 기록이 평일(월~금)에 한 번이라도 존재하면 상품 지급 대상이 된다.
 */
public class Programmers388351 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int[] time = timeArr(schedules);
        boolean[][] isLate = compareTime(time, timelogs, startday);
        int[] arr = new int[schedules.length];

        // 출근 기록을 for 문 순회
        for (int i = 0; i < timelogs.length; i++) {
            for (int j = 0; j < timelogs[i].length; j++) {
                if (isLate[i][j]) {         // 만약 isLate[i][j] 가 true 라면? (i 번째 사람의 j번 출근 기록) -> 평일 5일중 하루 이상 늦은 것
                    arr[i]++;               // arr[i] 번 값 증가 (i번째 사람의 지각한 횟수)
                }
            }
        }

        // arr 순회 하여 if == 0 이라면? -> 한번도 지각 하지 않은 사람 = 상품 지급자
        for (int a : arr) {
            if (a == 0) {
                answer++;       // 상품 지급 대상 수 + 1
            }
        }

        return answer;

    }

    // 실제 출근 시간 2차원 배열을 받아서 boolean 타입의 2차원 배열을 반환 한다. 출근 예정 시각과 비교 하여 평일 출근을 하루 라도 늦게 했다면 true
    private boolean[][] compareTime(int[] times, int[][] timelogs, int startDay) {
        boolean[][] arr = new boolean[timelogs.length][timelogs[0].length]; //배열 생성
        int[] dayArr = makeDateArr(startDay);

        for (int i = 0; i < timelogs.length; i++) {
            for (int j = 0; j < timelogs[i].length; j++) {
                if (times[i]  < timelogs[i][j] && (dayArr[j] != 7 && dayArr[j] != 6)) { // 평일에 출근 시간이 > 출근 예정 시간 이라면 true 로 바꾸기
                    arr[i][j] = true;
                }
            }
        }
        return arr;
    }

    // 출근 예정 시각을 받아서 + 10 분 더해, 배열로 반환 -> 6:70 분이 7:00보다 낮아지는 상황 발생.. 이거 때매 오래걸림 ㅜ
    // ex) 6:50 -> 7:00
    private int[] timeArr(int[] schedules){
        int[] arr = new int[schedules.length];
        for(int i = 0; i < schedules.length; i++){
            int hour = schedules[i] / 100;  // 650 -> 6
            int min = schedules[i] % 100; // 650 -> 50

            if(min >= 50){      // 어차피 10분만 더하면 되니, 50 이상
                hour += 1;      // 6 -> 7
                min = (min + 10) % 60;  // 50 + 10  % 60 -> 00,   55분 이라면? (55 + 10) % 60 -> 05
                arr[i] = hour * 100 + min;
            }else {
                arr[i] = schedules[i] + 10;     // 일반 적인 시간 이라면 그냥 10분 더하기
            }
        }
        return arr;
    }

    // 주말은 늦게 출근 해도 상품 지급 대상 에서 제외 되지 않는다.
    public int[] makeDateArr(int startday) {
        int[] date = new int[7];        // 배열 선언 (7일)

        for (int i = 0; i < 7; i++) {
            date[i] = startday;     // startday 를 먼저 i에 할당 하여, 7을 입력 받고 if문이 돌도록
            if (startday == 7) {
                startday = 1;
            } else {
                startday++;
            }
        }
        return date; // {7, 1, 2, 3, 4, 5, 6}
    }


}
