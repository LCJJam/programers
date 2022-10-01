package All_Progeramers_Problem;

import java.util.Stack;

public class RemovePair {
    public static void main(String[] args) {

        int answer = 0;
        String s = "baabaa";
        Stack<Character> stack = new Stack<>();
        //1. 문자제거하기
        for (int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }

        }
        answer = (stack.size() == 0) ? 1 : 0;

        System.out.println(answer);
    }
}
