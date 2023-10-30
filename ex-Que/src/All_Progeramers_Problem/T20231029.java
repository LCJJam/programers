package All_Progeramers_Problem;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538
 * 숫자 변환하기
 */

public class T20231029 {
    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;

        System.out.println(solution(x,y,n)); // 2

    }

    private static int solution(int x, int y, int n) {

        int answer = x == y ? 0 : -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y,0));

        while(!queue.isEmpty()){
            Node tmpNode = queue.poll();
            int target = tmpNode.y;
            int depth = tmpNode.depth;

            if(target == x + n) {
                return depth + 1;
            }  else if(target - n > x) {
                queue.add(new Node(target - n , depth + 1));
            }

            if (target == x * 2) {
                return depth + 1;
            }  else if(target % 2 == 0 && target / 2 > x) {
                queue.add(new Node(target / 2 , depth + 1));
            }

            if (target == x * 3) {
                return depth + 1;
            }  else if(target % 3 == 0 && target / 3 > x) {
                queue.add(new Node(target / 3 , depth + 1));
            }
        }

        return answer;

    }

    private static class Node {
        int y;
        int depth;
        public Node (int y , int depth) {
            this.y = y;
            this.depth = depth;
        }
    }

}
