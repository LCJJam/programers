package All_Progeramers_Problem;

import java.math.BigInteger;
import java.util.Arrays;

/*
 * 다음 큰 숫자
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 */
public class T20231101_2 {
    public static void main(String[] args) {
        System.out.println(solution(78)); // 83
    }

    private static int solution(int n) {

        int answer = n + 1; // 1,000,000 이하의 자연수
        int len = 0;
        while( n != 0 ){
            if(n % 2 == 1) len++;
            n /= 2;
        }

        // 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
        while(answer > n){

            int compNum = answer;
            int compLen = 0;

            while( compNum != 0 ){
                if(compNum % 2 == 1) compLen++;
                compNum /= 2;
            }
            // 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
            if(len == compLen) break;
            answer++;
        }

        // 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.

        return answer;
    }


}
