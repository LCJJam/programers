package All_Progeramers_Problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 영어 끝말잇기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */
public class T20231102 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(solution(n,words)));
    }

    private static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char c = words[0].charAt(0);
        int idx = 0;
        Set<String> set = new HashSet<>();
        for(String word : words){
            if(set.contains(word) || word.charAt(0) != c) {
                answer[0] = idx % n + 1;
                answer[1] = idx / n + 1;
                break;
            }
            set.add(word);
            c = word.charAt(word.length()-1);
            idx++;
        }


        return answer;
    }
}
