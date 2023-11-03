package All_Progeramers_Problem;

import java.util.Stack;

/*
 * 점프와 순간 이동
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */

public class T20231103 {
    public static void main(String[] args) {
        int N = 5;
        int result = 2;
        assert solution(N) == result : "expect " + result + " , sol " + solution(N); // VM 옵션 -ea 추가
    }

    private static int solution(int n) {
        // K 칸을 앞으로 점프하거나

        // (현재까지 온 거리) x 2 에 해당하는 위치로 순간이동

        // 순간이동을 하면 건전지 사용량이 줄지 않지만,
        // 앞으로 K 칸을 점프하면 K 만큼의 건전지 사용량이 듭니다.
        int jump = 0;
        while(n > 0){
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                jump++;
            }
        }

        return jump;
    }
}
