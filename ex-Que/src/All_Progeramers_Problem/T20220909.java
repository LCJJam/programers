package All_Progeramers_Problem;

import java.util.LinkedList;
import java.util.Queue;

public class T20220909 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        // 대기 트럭
        Queue<Integer> weight_que = new LinkedList<>();

        Queue<Integer> crossing_que = new LinkedList<>();
        Queue<Integer> time_que = new LinkedList<>();
        for(int truck : truck_weights){
            weight_que.add(truck);
        }

        int sum = 0;
        int time = 0;
        while(!weight_que.isEmpty()){
            time++;
            if(!time_que.isEmpty()){
                if(time - time_que.peek() == bridge_length){
                    time_que.poll();
                    sum -= crossing_que.poll();
                }
            }
            if(sum+weight_que.peek() < weight){
                crossing_que.add(weight_que.peek());
                sum += weight_que.poll();
                time_que.add(time);
            }

        }
        time += bridge_length;
        System.out.println(time);
    }
}
