package kakao_2020;
import java.util.*;

public class MaxCalculate {
    public long solution(String expression) {
        long answer = 0;
        answer = Math.max(answer,Math.abs(plus(0,expression,'-')));
        answer = Math.max(answer,Math.abs(plus(0,expression,'*')));
        answer = Math.max(answer,Math.abs(minus(0,expression,'+')));
        answer = Math.max(answer,Math.abs(minus(0,expression,'*')));
        answer = Math.max(answer,Math.abs(multi(0,expression,'+')));
        answer = Math.max(answer,Math.abs(multi(0,expression,'-')));

        return answer;
    }

    static int countChar(String str, char ch) {
        return (int) str.chars()
                .filter(c -> c == ch)
                .count();
    }

    static long plus(int depth, String str,char next) {
        long sum = 0 ;
        int len = countChar(str,'+');
        String[] plus_all = new String[len+1];
        plus_all = str.split("\\+");


        if(depth == 2){
            sum = Long.parseLong(plus_all[0]);
            for(int i=1;i<=len;i++){
                sum += Long.parseLong(plus_all[i]);
            }
            return sum;
        }
        if(next == '-'){
            sum = minus(depth+1,plus_all[0],'*');
        } else {
            sum = multi(depth+1,plus_all[0],'-');
        }
        for(int i=1; i<=len ; i++){
            if(next == '-'){
                sum += minus(depth+1,plus_all[i],'*');
            } else {
                sum += multi(depth+1,plus_all[i],'-');
            }
        }
        return sum;
    }
    static long minus(int depth, String str, char next) {
        long sum = 0;
        int len = countChar(str,'-');
        String[] plus_all = new String[len+1];
        plus_all = str.split("\\-");

        if(depth == 2){
            sum = Long.parseLong(plus_all[0]);
            for(int i=1;i<=len;i++){
                sum -= Long.parseLong(plus_all[i]);
            }
            return sum;
        }
        if(next == '+'){
            sum = plus(depth+1,plus_all[0],'*');
        } else {
            sum = multi(depth+1,plus_all[0],'+');
        }
        for(int i=1; i<=len ; i++){
            if(next == '+'){
                sum -= plus(depth+1,plus_all[i],'*');
            } else {
                sum -= multi(depth+1,plus_all[i],'+');
            }
        }
        return sum;
    }
    static long multi(int depth, String str, char next) {
        long sum = 1 ;
        int len = countChar(str,'*');
        String[] plus_all = new String[len+1];
        plus_all = str.split("\\*");

        if(depth == 2){
            sum = Long.parseLong(plus_all[0]);
            for(int i=1;i<=len;i++){
                sum *= Long.parseLong(plus_all[i]);
            }
            return sum;
        }
        if(next == '-'){
            sum = minus(depth+1,plus_all[0],'+');
        } else {
            sum = plus(depth+1,plus_all[0],'-');
        }
        for(int i=1; i<=len ; i++){
            if(next == '-'){
                sum *= minus(depth+1,plus_all[i],'+');
            } else {
                sum *= plus(depth+1,plus_all[i],'-');
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxCalculate T = new MaxCalculate();
        System.out.println("100-200*300-500+20");
        System.out.println(T.solution("100-200*300-500+20"));
        System.out.println(T.solution("50*6-3*2"));

        String a = "1";
        String[] b = new String[1];
    }
}
