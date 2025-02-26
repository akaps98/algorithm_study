package choiyejin.programmers;

public class programmers12943 {

	    public int solution(int[] schedules, int[][] timelogs, int startday) {
	        int n = schedules.length;  // 직원 수
	        int eligibleCount = 0;  // 상품을 받을 수 있는 직원 수

	        // 주말 (토요일, 일요일) 체크를 위한 상수
	        int SATURDAY = 6;
	        int SUNDAY = 7;

	        // 직원마다 상품을 받을 수 있는지 확인
	        for (int i = 0; i < n; i++) {
	            boolean eligible = true;  // 기본적으로 상품을 받을 수 있다고 가정

	            // 일요일부터 시작하여 7일간 출근 시각을 확인
	            for (int j = 0; j < 7; j++) {
	                // 실제 요일 계산 (startday 기준, 1이 월요일부터 시작)
	                int currentDay = (startday + j - 1) % 7 + 1;

	                // 주말이면 건너뜀
	                if (currentDay == SATURDAY || currentDay == SUNDAY) {
	                    continue;
	                }

	                // 희망 출근 시각에 10분 추가한 시각 계산
	                int hopedTime = schedules[i];
	                int hour = hopedTime / 100;  // 시
	                int minute = hopedTime % 100;  // 분

	                // 10분 추가
	                minute += 10;

	                // 만약 분이 60 이상이면 1시간 추가하고, 분은 0으로 설정
	                if (minute >= 60) {
	                    minute -= 60;
	                    hour += 1;
	                }

	                // 새로운 시각을 4자리 수로 계산
	                hopedTime = hour * 100 + minute;

	                // 실제 출근 시각이 희망 시각 + 10분 이내라면 상품을 받을 수 있음
	                if (timelogs[i][j] > hopedTime) {
	                    eligible = false;  // 늦으면 상품을 받을 수 없음
	                    break;
	                }
	            }

	            // 상품을 받을 수 있으면 eligibleCount 증가
	            if (eligible) {
	                eligibleCount++;
	            }
	        }

	        return eligibleCount;  // 상품을 받을 수 있는 직원 수 반환
	    }


}
