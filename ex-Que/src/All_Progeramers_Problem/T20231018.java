package All_Progeramers_Problem;

import java.util.ArrayList;
import java.util.List;

/*
 * 당구 연습
 * https://school.programmers.co.kr/learn/courses/30/lessons/169198
 */
public class T20231018 {
    public static void main(String[] args) {
        int m = 4; // 가로
        int n = 4; // 세로

        // 공 좌표
        int startX = 2;
        int startY = 2;

        // 목표 공 좌표
//        int[][] balls = {{4,5},{6,5},{5,4},{5,6}};
//        int[][] balls = {{4,4},{6,6},{6,4},{4,6}};
        int[][] balls = {{1,1},{1,2},{1,3},{2,1},{2,3},{3,1},{3,2},{3,3}};


        int[] answer = solution(m,n,startX,startY,balls);

        for(int i : answer) {
            System.out.print(i + ", ");
        }


        // 각 회마다 머쓱이가 친 공이 굴러간 거리의 최솟값의 제곱
        // result : {52,37,116}
    }

    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        List<Integer> list = new ArrayList<>();
        // 원쿠션
        for(int[] a : balls) {
            int minX;
            int minY;
            if(a[0] == startX) {
                minX = m - a[0] < a[0] ? 2*m - a[0] : -a[0];
                minY = startY > a[1] ? 2*n - a[1] : -a[1];
            } else if(a[1] == startY){
                minX = startX > a[0] ? 2*m - a[0] : -a[0];
                minY = n - a[1] < a[1] ? 2*n - a[1] : -a[1];
            } else {
                minX = (startX + a[0]) < 2 * m - startX -a[0] ? -a[0] : 2*m -a[0];
                minY = (startY + a[1]) < 2 * n - startY -a[1] ? -a[1] : 2*n -a[1];
            }



            int result = (int) Math.min(
                    Math.pow(startX-a[0],2) + Math.pow(startY-minY,2),
                    Math.pow(startX-minX,2) + Math.pow(startY-a[1],2)
            );


            list.add(result);
        }

        int[] answer = new int[balls.length];
        for(int i = 0 ; i < balls.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
