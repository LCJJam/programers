package Greedy;
import java.util.*;
public class GymSuit {
    public static void main(String[] args) {

        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};

        int answer = 0;
        int[] arr = new int[n];

        // setting
        for(int i=0;i<n;i++){
            arr[i] = 1;
        }

        for(int i : lost){
            arr[i-1] -= 1;
        }

        for(int i : reserve){
            arr[i-1] += 1;
        }

        if(arr[0] == 0 && arr[1] == 2) {
            arr[0] = 1;
            arr[1] = 1;
        }

        for(int i=1; i<n-1; i++){
            if(arr[i-1] == 2 && arr[i] == 0){
                arr[i-1] = 1;
                arr[i] = 1;
            } else if(arr[i] == 0 && arr[i+1] == 2) {
                arr[i] = 1;
                arr[i+1] = 1;
            }
        }

        for(int i=0;i<n;i++){
            if(arr[i] != 0) answer++;
        }

        System.out.println(answer);


    }
}
