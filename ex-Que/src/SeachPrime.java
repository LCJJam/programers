import java.util.*;
public class SeachPrime {
    static Set<Integer> list = new HashSet<>();
    public static void main(String[] args) {

        int answer = 0;
        String numbers2 = "17";
        String numbers = "011";

        PriorityQueue<Integer> que = new PriorityQueue<>();

        setArr("",numbers);
        for(int a : list){
            que.add(a);
        }
        for(int a : que){
            if(is_prime(a)) answer++;
        }
        System.out.println(answer);

    }

    public static void setArr(String target,String numbers){
        if(numbers.length() == 0) {
            list.add(Integer.parseInt(target));
            return;
        }
        if(target.length() != 0) {list.add(Integer.parseInt(target));}
        int len = numbers.length();
        for(int i =0; i<len ; i++){
            StringBuffer sb = new StringBuffer();
            sb.append(numbers);
            setArr(target + sb.charAt(i),sb.deleteCharAt(i).toString());
        }
    }

    public static boolean is_prime(int number) {

        // 0 과 1 은 소수가 아니다
        if(number < 2) {
            return false;
        }

        // 2 는 소수다
        if(number == 2) {
            return true;
        }


        for(int i = 2; i < number; i++) {

            // 소수가 아닐경우
            if(number % i == 0) {
                return false;
            }
        }
        // 위 반복문에서 약수를 갖고 있지 않는경우 소수다.
        return true;
    }

}
