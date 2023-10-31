package All_Progeramers_Problem;

import java.util.Arrays;
/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951
 * JadenCase 문자열 만들기
 */
public class T20231031 {
    public static void main(String[] args) {
        String answer = "";
        String s = "3people unFollowed me     ";
        System.out.println(solution(s));
    }

    private static String solution(String input) {
        if (input == null || input.isEmpty()) {
            return input; // 빈 문자열이나 null이면 그대로 반환
        }

        StringBuilder result = new StringBuilder();
        int spaceIndex = -1; // 띄어쓰기의 인덱스

        do {
            // 이전 띄어쓰기 다음의 단어 시작 인덱스를 찾음
            int wordStartIndex = spaceIndex + 1;
            System.out.println(result);

            // 다음 띄어쓰기의 인덱스를 찾음
            spaceIndex = input.indexOf(" ", wordStartIndex);

            if (spaceIndex == -1) {
                // 다음 띄어쓰기가 없는 경우, 마지막 단어임
                spaceIndex = input.length();
            }

            if (spaceIndex == wordStartIndex) {
                result.append(" ");
                continue;
            }

            // 현재 단어 추출
            String word = input.substring(wordStartIndex, spaceIndex);

            // 단어의 첫 글자를 대문자로, 나머지 글자를 소문자로 변환
            String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();

            // 변환된 단어를 결과에 추가
            result.append(capitalizedWord);

            if (spaceIndex < input.length()) {
                // 단어 뒤에 띄어쓰기 추가 (마지막 단어는 제외)
                result.append(" ");
            }

        } while (spaceIndex < input.length() - 1);

        return result.toString();
    }
}
