package All_Progeramers_Problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 코딩 테스트 공부
 * https://school.programmers.co.kr/learn/courses/30/lessons/118668
 */
public class T20231031_2 {
    public static void main(String[] args) {
//        int alp = 10; // 알고력
//        int cop = 10; // 코딩력
//        int[][] problems = {{10,15,2,1,2},{20,20,3,3,4}};

        int alp = 0; // 알고력
        int cop = 0; // 코딩력
        int[][] problems = {{0, 0, 2, 1, 2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}};

        System.out.println(solution(alp,cop,problems)); // 15


    }



    private static int solution(int alp, int cop, int[][] problems) {
        int answer = Integer.MAX_VALUE;
        int maxAlp = 0;
        int maxCop = 0;
        for(int[] problem : problems){
            maxAlp = Math.max(problem[0],maxAlp);
            maxCop = Math.max(problem[1],maxCop);
        }

        int[][] minVisited = new int[6001][6001];


        for(int[] visit : minVisited) {
            Arrays.fill(visit,Integer.MAX_VALUE);
        }

        minVisited[alp][cop] = 0;

        for(int i = alp ; i <= 500 ; i++){
            for(int j = cop; j <= 500; j++){
                for(int[] problem : problems){
                    if(i >= maxAlp && j >= maxCop) {
                        answer = Math.min(answer, minVisited[i][j]);
                        continue;
                    }
                    if(i >= problem[0] && j >= problem[1]){
                        minVisited[i + problem[2]][j + problem[3]] = Math.min(minVisited[i][j] + problem[4] , minVisited[i + problem[2]][j + problem[3]]);
                    }
                    if(i + problem[2] >= maxAlp && j + problem[3] >= maxCop ) {
                        answer = Math.min(answer , minVisited[i + problem[2]][j + problem[3]]);
                    }

                    minVisited[i+1][j] = Math.min(minVisited[i+1][j] , minVisited[i][j] +1);
                    minVisited[i][j+1] = Math.min(minVisited[i][j+1] , minVisited[i][j] +1);

                }
            }
        }
        return answer;
    }


    private static int solution2(int alp, int cop, int[][] problems) {

        int maxAlp = 0;
        int maxCop = 0;



        for(int[] problem : problems){
            maxAlp = Math.max(problem[0],maxAlp);
            maxCop = Math.max(problem[1],maxCop);
        }

        int[][] minVisited = new int[6001][6001];


        int minTime = maxAlp + maxCop;

        for(int[] visit : minVisited) {
            Arrays.fill(visit,minTime);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(alp,cop,0));
        while (!queue.isEmpty()){
            Node tmpNode = queue.poll();
            if(tmpNode.alp >= maxAlp && tmpNode.cop >= maxCop) {
                minTime = Math.min(minTime, tmpNode.time);
                continue;
            }

            if(tmpNode.time > minTime) continue;

            for(int[] problem : problems){
                if(tmpNode.alp < problem[0] || tmpNode.cop < problem[1]) continue;
                if(minVisited[tmpNode.alp + problem[2]][tmpNode.cop + problem[3]] > tmpNode.time + problem[4]){
                    minVisited[tmpNode.alp + problem[2]][tmpNode.cop + problem[3]] = tmpNode.time + problem[4];
                    queue.add(new Node(tmpNode.alp + problem[2], tmpNode.cop + problem[3], tmpNode.time + problem[4]));
                }

            }
            if(tmpNode.alp + 1 <= maxAlp && minVisited[tmpNode.alp + 1][tmpNode.cop] > tmpNode.time +1 ){
                minVisited[tmpNode.alp + 1][tmpNode.cop] = tmpNode.time +1;
                queue.add(new Node(tmpNode.alp + 1, tmpNode.cop, tmpNode.time + 1));
            }

            if(tmpNode.cop + 1 <= maxCop && minVisited[tmpNode.alp][tmpNode.cop + 1] > tmpNode.time +1 ){
                minVisited[tmpNode.alp][tmpNode.cop + 1] = tmpNode.time +1;
                queue.add(new Node(tmpNode.alp, tmpNode.cop + 1, tmpNode.time + 1));
            }
        }





        return minTime;
    }

    private static class Node {
        int alp;
        int cop;
        int time;
        public Node(int alp, int cop, int time){
            this.alp = alp;
            this.cop = cop;
            this.time = time;
        }

        @Override
        public String toString(){
            return "alp:"+alp + " , " + "cop:"+cop + " , " + "time:"+time;
        }
    }
}
