import java.util.*;
public class Carpet {
    public static void main(String[] args) {
        int brown = 10; int yellow=2;
        int brown1 = 8; int yellow1=1;
        int brown2 = 24; int yellow2=24;

        int[] answer = new int[2];

        // yellow = N * M ;
        // brown = (N+2) * (M+2) - yellow = 2*(N+M) + 4;
        int target = (brown - 4)/2;
        for(int i = 1; i< target ; i++){
            if(i * (target-i) == yellow){
                answer[0] = target-i+2;
                answer[1] = i+2;
                break;
            }
        }






        System.out.println(answer[0]);
        System.out.println(answer[1]);

    }
}
