package Greedy;

import java.util.Arrays;
import java.util.Collections;

public class LifeBoat {
    public static void main(String[] args) {

        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int answer = 0;

        //Integer reversePeople[] = Arrays.stream(people).boxed().toArray(Integer[]::new);
        //Arrays.sort(reversePeople,Collections.reverseOrder());
        Arrays.sort(people);
        int firstIdx = 0;
        int lastIdx = people.length-1;
        int flag = 0;
        while(flag != people.length){
            if(firstIdx == lastIdx) {
                flag++;
            } else if(people[lastIdx] + people[firstIdx] <= limit){
                firstIdx++;
                lastIdx--;
                flag+=2;
            } else {
                lastIdx--;
                flag++;
            }
            answer++;
        }
        System.out.println(answer);


    }
}
