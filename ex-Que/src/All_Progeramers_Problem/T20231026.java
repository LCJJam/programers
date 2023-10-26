package All_Progeramers_Problem;

import java.util.LinkedList;
import java.util.Queue;

public class T20231026 {
    public static void main(String[] args) {
        int[] queue1 = {3,2,7,2};
        int[] queue2 = {4,6,5,1};

        System.out.println(solution(queue1,queue2));
    }

    private static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int maxSize = queue1.length + queue2.length;
        int qSum1 = 0;
        int qSum2 = 0;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        for(int i : queue1){
            que1.add(i);
            qSum1 += i;
        }

        for(int i : queue2){
            que2.add(i);
            qSum2 += i;
        }

        int start = 0;
        while(qSum1 != qSum2 && start < 2 * maxSize){
            if(qSum1 > qSum2) {
                int q1 = que1.poll();
                qSum1 -= q1;
                qSum2 += q1;
                que2.add(q1);
            } else {
                int q2 = que2.poll();
                qSum1 += q2;
                qSum2 -= q2;
                que1.add(q2);
            }
            start++;
        }

        return start == 2 * maxSize ? -1 : start;
    }
}
