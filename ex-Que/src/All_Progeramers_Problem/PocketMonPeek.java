package All_Progeramers_Problem;

import java.util.HashSet;
import java.util.Set;

public class PocketMonPeek {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        Set<Integer> pockets = new HashSet<>();
        int maxSize = nums.length / 2;
        for (int num : nums) {
            pockets.add(num);
            if (pockets.size() == maxSize) {
                break;
            }
        }
        int answer = pockets.size();
        System.out.println(answer);

    }
}
