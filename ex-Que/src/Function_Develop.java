import java.util.LinkedList;
import java.util.Queue;

public class Function_Develop {

    public static void main(String[] args) {
        System.out.println("3");

        int[] progress_1 = {93, 30, 55};
        int[] speeds_1 = {1, 30, 5};

        int[] progress_2 = {95, 90, 99, 99, 80, 99};
        int[] speeds_2 = {1, 1, 1, 1, 1, 1};

        int idx = 0;
        boolean flag = true;
        Queue<Integer> Que = new LinkedList<>();
        while(flag){
            int count = 0;
            boolean flag2 = true;
            for(int i=idx ; i < progress_1.length ; i++){
                progress_1[i] += speeds_1[i];
                if(progress_1[i] >= 100 && flag2) {
                    idx++;
                    count++;
                } else {
                    flag2 = false;
                }
            }
            if(idx == progress_1.length) flag = false;
            if(count != 0) Que.add(count);
        }
        System.out.println(Que);
        int[] answer = new int[Que.size()];
        int k = Que.size();
        for(int i=0; i < k ; i++){
            answer[i] = Que.poll();
            System.out.println(answer[i]);
        }



    }

}
