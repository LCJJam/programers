package Programers_dev_2022;

import java.util.Arrays;

public class Test3 {
    static long[] map;
    public long solution(int k) {
        long answer = 0;
        map = new long[51];
        // 2개 : 1
        // 3개 : 7
        // 4개 : 4
        // 5개 : 2,3,5
        // 6개 : 0,6,9
        // 7개 : 8
        // 첫째 0 인 경우
        if(k > 6){
            answer = sum(k,1) - sum(k-6,1);
        } else {
            answer = sum(k,1);
        }
        // 0이 아닌 경우
        //System.out.println(Arrays.toString(map));
        return answer;
    }
    static long sum(int n,int sumValue){
        if(n == 0) {
            return sumValue;
        }
        if(n == 1 || n < 0) return 0;
        if(map[n] != 0) return map[n]*sumValue;
        map[n] = sum(n-2,sumValue*1) +
                sum(n-3,sumValue*1) +
                sum(n-4,sumValue*1) +
                sum(n-5,sumValue*3) +
                sum(n-6,sumValue*3) +
                sum(n-7,sumValue*1);
        //System.out.println(n + " : "+ map[n]);
        return map[n];
    }
    public static void main(String[] args) {
        Test3 T = new Test3();
        long time = System.currentTimeMillis();
        System.out.print(T.solution(5) + "는 " + "5   ");
        System.out.println(System.currentTimeMillis()- time +"초");
        time = System.currentTimeMillis();
        System.out.print(T.solution(6) + "는 " + "7   ");
        time = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis()- time +"초");
        time = System.currentTimeMillis();
        System.out.print(T.solution(11)+ "는 "+ "99   ");
        time = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis()- time +"초");
        time = System.currentTimeMillis();
        System.out.print(T.solution(40)+ "는 " + "600094277   ");
        System.out.println(System.currentTimeMillis()- time +"초");
        time = System.currentTimeMillis();
        System.out.print(T.solution(48)+ "는 " + "44599558843  ");
        System.out.println(System.currentTimeMillis()- time +"초");

    }
}
