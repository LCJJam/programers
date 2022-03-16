package Greedy;
import java.util.*;
public class MakeBigNum {
    public static void main(String[] args) {

        String answer = "";

        String number2 = "1924";
        String number = "654321";
        int k = 5;

        while(k != 0) {
            if(number.length() == k) {
                number = "";
                break;
            }
            int max = 0;
            int idx = 0;
            for (int j = 0; j <= k; j++) {
                if (Character.getNumericValue(number.charAt(j)) > max) {
                    max = Character.getNumericValue(number.charAt(j));
                    idx = j;
                }
                if(Character.getNumericValue(number.charAt(j)) == 9) break;
            }
            answer += max;
            k -= idx;
            System.out.println(number);
            number = number.substring(idx + 1, number.length());
        }
        answer += number;
        System.out.println(answer);
    }
}
