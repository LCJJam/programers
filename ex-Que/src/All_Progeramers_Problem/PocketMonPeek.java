package All_Progeramers_Problem;

import java.util.HashSet;
import java.util.Set;

public class PocketMonPeek {
    public static void main(String[] args) {
        int answer = 0;
        int[] nums = {3,3,3,2,2,4};
        Set<Integer> pockets = new HashSet<>();
        int size = nums.length/2;
        for(int a : nums){
            if(!pockets.contains(a)) pockets.add(a);
            answer = pockets.size();
            if(pockets.size() == size ) {
                break;
            }
        }

        System.out.println(answer);

    }
}
