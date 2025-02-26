package choiyejin.programmers;

import java.util.ArrayList;


public class programmers131128 {

	    public String solution(String X, String Y) {
	        // 공통된 숫자들을 저장하는 ArrayList
	        ArrayList<Integer> answer = new ArrayList<>();

	        // 0-9까지 몇 개있는지 저장할 배열
	        int[] countX = new int[10];
	        int[] countY = new int[10];

	        // X와 Y에서 charArray에서 입력된 숫자들을 하나씩 넣어서 몇번 나오는지 카운팅
	        // ex) [100]-> countX [2,1,0,0,0,......0]
	        for (char c : X.toCharArray()) {
	            countX[c - '0']++;
	        }
	        for (char c : Y.toCharArray()) {
	            countY[c - '0']++;
	        }

	        // 0부터 9까지 각 숫자의 최소 빈도 수를 구해 결과에 추가
	        // i는 숫자를 나타내고, 9부터 0까지 내려가면서 공통 등장 횟수를 체크합니다.
	        // j는 각 숫자가 몇 번 등장하는지에 맞춰서 결과에 숫자를 추가합니다.
	        for (int i = 9; i >= 0; i--) {
	            int commonCount = Math.min(countX[i], countY[i]);
	            for (int j = 0; j < commonCount; j++) {
	                answer.add(i); // 숫자들을 ArrayList에 추가
	            }
	        }

	        // 결과가 비어있으면 -1을 리턴
	        if (answer.size() == 0) {
	            return "-1";
	        }

	        // 만약 결과에 0만 존재하면 "0"을 리턴
	        if (answer.get(0) == 0) {
	            return "0";
	        }

	        // ArrayList에 저장된 숫자들을 문자열로 변환
	        StringBuffer result = new StringBuffer();
	        for (int num : answer) {
	            result.append(num); // 숫자들을 StringBuffer에 추가
	        }
	        //StringBuffer에 있는 값 출력
	        return result.toString();
	    }
	

	public static void main(String[] args) {
		programmers131128 pr = new programmers131128();
		String result =pr.solution("100","123450");
		System.out.println(result);

	}

}
