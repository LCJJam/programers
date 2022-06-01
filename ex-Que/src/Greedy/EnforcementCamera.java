package Greedy;

import java.util.*;

public class EnforcementCamera {
    public static void main(String[] args) {

        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};

        int answer = 0;

        Arrays.sort(routes, (a,b) ->  Integer.compare(a[0], b[0]));

        int length = routes.length;
        int start = routes[0][0];
        int end = routes[0][1];
        for(int i=1;i<length;i++){
            if(routes[i][0] < end){
                end = Math.min(end,routes[i][1]);

            } else {
                answer++;
                end = routes[i][1];
            }
        }

        for(int[] a : routes){
            System.out.println(Arrays.toString(a));
        }




        System.out.println(answer);
    }
}
