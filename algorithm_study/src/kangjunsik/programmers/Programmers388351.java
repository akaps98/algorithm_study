package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/388351
 * 유연근무제
 */

public class Programmers388351 {
    public static void main(String[] args) {
        int[] schedules = {730, 850, 700, 720};
        int[][] timelogs = {{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}};
        int startday = 1;

        System.out.println(solution(schedules, timelogs, startday));
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for(int i = 0; i < schedules.length; i++) { // 모든 직원 순회; schedules[i] 사용 예정
            boolean isLate = false;
            for(int j = 0; j < timelogs[i].length; j++) { // 각 직원의 희망 출근 시간 순회; timelogs[i][j] 사용 예정
                if(startday != 7) { // 시작날짜가 일요일로 설정되지 않았다면?
                    if(j != (7 - startday) - 1 && j != (7 - startday)) { // j 값이 어떤 게 나올 때 주말일지 판단함
                        int realSchedule = schedules[i] + 10; // 10분 추가해서까지는 지각이 아니니 10분을 더해줌

                        if(realSchedule % 100 >= 60) { // 만약 60분을 넘어버리면, 시간에 1을 더해주고 분에 60을 뺀다
                            realSchedule += 100; // 한시간 추가
                            realSchedule -= realSchedule % 100 - (realSchedule % 100 - 60); // 초과한 시간만큼 뺌
                        }

                        if(timelogs[i][j] > realSchedule) { // 지각
                            isLate = true; // 지각 했으니 isLate를 true로 변경해 주고
                            break; // for-loop를 더 돌려볼 필요가 없음. 바로 for-loop escaping
                        }
                    }
                } else { // 시작날짜가 일요일로 설정되었다면?
                    if(j != 0 && j != 6) { // 시작날짜가 일요일이라면 j값이 0과 6일때만 일요일/토요일
                        int realSchedule = schedules[i] + 10; // 10분 추가해서까지는 지각이 아니니 10분을 더해줌

                        if(realSchedule % 100 >= 60) { // 만약 60분을 넘어버리면, 시간에 1을 더해주고 분에 60을 뺀다
                            realSchedule += 100; // 한시간 추가
                            realSchedule -= realSchedule % 100 - (realSchedule % 100 - 60); // 초과한 시간만큼 뺌
                        }

                        if(timelogs[i][j] > realSchedule) { // 지각
                            isLate = true; // 지각 했으니 isLate를 true로 변경해 주고
                            break; // for-loop를 더 돌려볼 필요가 없음. 바로 for-loop escaping
                        }
                    }
                }
            }

            if(!isLate) { // 직원이 모든 날에 지각을 하지 않았음
                answer++;
            }
        }

        return answer;
    }
}
