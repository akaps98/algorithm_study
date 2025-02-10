package kangjunsik.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/172928
 * 공원 산책
 */

public class Programmers172928 {
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        // find the initial spot of S
        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
                break;
            }
        }
        
        for (String route : routes) {
            String[] splitRoute = route.split(" ");
            String way = splitRoute[0]; // "N", "E", "W", "S"
            int movement = Integer.parseInt(splitRoute[1]);
            
            // current location
            int xAxis = answer[0];
            int tempXAxis = xAxis;
            int yAxis = answer[1];
            int tempYAxis = yAxis;
            
            boolean isMovable = true;
            
            for (int i = 0; i < movement; i++) {
                if (way.equals("N")) {
                    xAxis--;
                } else if (way.equals("E")) {
                    yAxis++;
                } else if (way.equals("W")) {
                    yAxis--;
                } else { // "S"
                    xAxis++;
                }

                if (xAxis < 0 || xAxis >= park.length || yAxis < 0 || yAxis >= park[0].length()) {
                    isMovable = false;
                    break;
                }
                
                if (park[xAxis].charAt(yAxis) == 'X') {
                    isMovable = false;
                    break;
                }
            }

            if (isMovable) {
                answer[0] = xAxis;
                answer[1] = yAxis;
            }
        }
        
        return answer;
    }
}
