package All_Progeramers_Problem;

import java.util.*;

/*
 * 뒤에 있는 큰 수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */
public class T_20231019 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5};
        int[] answer = new int[numbers.length];

        Stack<Integer> stackNum = new Stack<>();
        Stack<Integer> stackIdx = new Stack<>();

        int index = 0;
        for(int i : numbers){
            if(stackNum.isEmpty()) {
                stackNum.push(i);
                stackIdx.push(index);
            } else {
                while (!stackNum.isEmpty() && stackNum.peek() < i) {
                    stackNum.pop();
                    answer[stackIdx.pop()] = i;
                }
                stackNum.push(i);
                stackIdx.push(index);
            }

            index++;
        }
        index = 0;
        for(int i : answer) {
            if (i == 0 ) answer[index] = -1;
            index++;
        }

        System.out.println(Arrays.toString(answer));



    }
}
