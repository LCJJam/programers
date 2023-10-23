package All_Progeramers_Problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 롤케이크 자르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */
public class T20231023 {
    public static void main(String[] args) {

        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2}; // 2
//        int[] topping = {1, 2, 3, 1, 4}; // 0

        int answer = 0;

        Map<Integer,Integer> frontToppingMap = new HashMap<>();
        Map<Integer,Integer> backToppingMap = new HashMap<>();


        for(int i : topping) {
            backToppingMap.put(i,backToppingMap.getOrDefault(i,0) + 1);
        }

        for (int i : topping) {
            frontToppingMap.put(i,frontToppingMap.getOrDefault(i,0) + 1);
            backToppingMap.put(i,backToppingMap.getOrDefault(i, 0) - 1);
            if(backToppingMap.get(i) == 0) backToppingMap.remove(i);
            if(frontToppingMap.size() == backToppingMap.size()) answer++;
        }

        System.out.println(answer);

    }
}
