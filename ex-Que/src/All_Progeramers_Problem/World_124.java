package All_Progeramers_Problem;

public class World_124 {
    public static void main(String[] args) {
        int n = 4;
        String answer = "";
        int tmp = 1;
        int idx = 0;
        while(n >= tmp){
            n -= tmp;
            tmp*=3;
            idx++;
        }
        String s = "2three45sixseven";

        System.out.println(Integer.parseInt(s));
        System.out.println(n);
        if(n == 0) answer = "1";
        while(n > 0 || n%3 != 0){
            int a = n%3;
            if(a == 0){
                answer = "1" + answer;
            } else if(a == 1) {
                answer = "2" + answer;
            } else {
                answer = "4" + answer;
            }
            n = n/3;
        }
        while(answer.length() != idx){
            answer = "1" + answer;
        }
        System.out.println(idx + " : " + answer);
    }
}
