package Programers_dev_2022;

import kakao_2020.MaxCalculate;

import java.util.*;

public class Test1 {
    public String solution(String[] registered_list, String new_id) {
        String answer = "";
        Set<String> list = new HashSet<>();
        Collections.addAll(list, registered_list);
        // Search Num Idx
        int idx = 0;
        for(int i=0;i<new_id.length();i++){
            char tmp = new_id.charAt(i);
            if( tmp <= '9' && tmp >= '0'){
                idx = i;
                break;
            }
        }
        System.out.println(idx);
        String S = "";
        String N = "";
        if(idx != 0){
            S = new_id.substring(0,idx);
            N = new_id.substring(idx);
        } else {
            S = new_id;
        }


        // 체크
        /*
        boolean notSmall = false;
        boolean sFlag = true;
        boolean nFlag = false;
        for(int i=0;i<new_id.length();i++){
            char tmp = new_id.charAt(i);
            if(sFlag){
                if(new_id.charAt(i) > 'z' || new_id.charAt(i) < 'a'){
                    if( tmp+0 < 10 && tmp+0 >= 0){
                        idx = i; // 첫번째 숫자 idx 체크
                        nFlag = true;
                        sFlag = false;
                    } else {
                        return "S의 알파벳 소문자가 아닌 문자가 포함되어 있습니다."
                    }
                }
            }
            if(nFlag){

            }
        }
        if(idx < 3 || new_id.length() < 3) return "S의 길이가 3 미만입니다.";
        if()
        */
        if(list.contains(new_id)){
            while(list.contains(S+N)){
                if(N.equals("")) N = "0";
                int num = Integer.parseInt(N)+1;
                System.out.println(num);
                N = String.valueOf(num);
            }
            return S+N;
        }
        return new_id;
    }

    public static void main(String[] args) {
        Test1 T = new Test1();

        System.out.println(T.solution(new String[] {"card","ace13","ace16"},"ace15"));
        System.out.println(T.solution(new String[] {"card","bird98","ace16"},"bird98"));

    }
}
