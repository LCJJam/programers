package All_Progeramers_Problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 인사고과
 * https://school.programmers.co.kr/learn/courses/30/lessons/152995
 */
public class T20231030 {
    public static void main(String[] args) {


        int[][] scores = {{2,1},{2,2},{2,3},{3,1}};
//        int[][] scores = {{3,2},{2,3},{3,2},{2,3}};
//        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        System.out.println(solution(scores));

    }

    private static int solution(int[][] scores) {
        int answer = 0;
        int targetX = scores[0][0];
        int targetY = scores[0][1];
        int targetXY = targetX + targetY;
        // score[n][0] = 근무 점수
        // score[n][1] = 동료 점수

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });

        System.out.println(Arrays.deepToString(scores));

        int prevX = scores[0][0];
        int prevY = 0;
        for(int[] score : scores){
            if (score[0] == prevX || score[1] >= prevY) {
                prevY = Math.max(prevY, score[1]);
                queue.add(score[1] + score[0]);
            } else {
                if(score[0] == targetX && score[1] == targetY) return -1;
            }
        }

        int idx = 1;
        while (!queue.isEmpty()){
            int num = queue.poll();
            if( num == targetXY ) return idx;
            idx++;
        }


//        int[] workScore = new int[scores.length];
//        int[] partnerScore = new int[scores.length];
//        for (int[] score : scores) {
//            workScore[score[0]] = Math.max(workScore[score[0]], score[1]);
//            partnerScore[score[1]] = Math.max(partnerScore[score[1]], score[0]);
//            if(score[0] > scores[0][0] && score[1] > scores[0][1]) return -1;
//        }
//
//        for(int i = 0; i < scores.length; i++){
//
//        }



        return answer;
    }


}
