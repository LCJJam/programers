import java.util.*;

public class Target_Number {
    public static void main(String[] args) {

        int answer = 0;

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int[] numbers_2 = {4, 1, 2, 1};
        int target_2 = 4;

        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        for(int i = 0 ; i < numbers.length ; i++) {
            Queue<Integer> tmp_que = new LinkedList<>();
            for( int a : que ) {
                tmp_que.add(a+numbers[i]);
                tmp_que.add(a-numbers[i]);
            }
            que = new LinkedList<>(tmp_que);
        }

        System.out.println(que);
        for( int idx : que ){
            if(idx == target) answer++;
        }
        System.out.println(answer);

    }
}
