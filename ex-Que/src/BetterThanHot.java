import java.util.*;
public class BetterThanHot {

    public static void main(String[] args) {

        int answer = 0;

        int[] scoville = {9,6,8,7,5,5,4,2,1};
        int K = 188;

        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        for(int a : scoville){
            que.add(a);
        }
        while(true){
            System.out.println(que);
            if(que.size() == 1) {
                if(que.poll() >= K){
                    break;
                } else {
                    answer = -1;
                }
                break;
            }
            int tmp1 = que.poll();
            int tmp2 = que.poll();
            if(tmp1 >= K) break;
            else{
                que.add(tmp1 + (tmp2*2));
                answer ++;
            }
        }




        System.out.println(answer);
    }
}
