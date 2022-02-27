import java.util.*;

public class DoublePriorityQue {
    public static void main(String[] args) {
        int[] answer = new int[2];

        String[] operations2 = {"I 16","D 1"};
        String[] operations = {"I 7","I 5","I -5","D -1"};

        PriorityQueue<Integer> que = new PriorityQueue<>();
        PriorityQueue<Integer> revQue = new PriorityQueue<>(Comparator.reverseOrder());
        for(String a : operations) {
            String func = a.split(" ")[0];
            String num = a.split(" ")[1];
            if(func.equals("I")){
                que.add(Integer.parseInt(num));
                revQue.add(Integer.parseInt(num));
            } else {
                if(num.equals("-1")){
                    revQue.remove(que.poll());
                } else {
                    que.remove(revQue.poll());
                }
            }
            System.out.println(que);
        }
        int len = que.size();
        if(len == 0){
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = que.poll();
            answer[1] = revQue.poll();
        }


        System.out.println(answer[0] + " , " + answer[1]);

    }
}
