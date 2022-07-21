package All_Progeramers_Problem;

import java.util.*;

public class T20220720 {
    public static void main(String[] args) {
        int answer = 0;
        String[] strs = {"ba","na","n","a"};
        String[] strs3 = {"app","ap","p","l","e","ple","pp"};
        String[] strs2 = {"ba","an","nan","ban","n"};
        String t = "banana";
        String t1 = "apple";

        int len = t.length();
        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> tmp_que = new LinkedList<>();
        boolean Flag = false;
        boolean loop_Flag = false;
        boolean[] visited = new boolean[len];
        que.add(0);
        do {
            int tmp_idx = que.poll();
            for(String s : strs){
                int lenth = s.length();
                loop_Flag = true;
                if(tmp_idx+lenth > t.length()) continue;
                for(int j = 0; j < lenth; j++) {
                    if(t.charAt(tmp_idx + j) != s.charAt(j)) {
                        loop_Flag = false;
                        break;
                    }
                }
                if(!loop_Flag) {
                    continue;
                }
                System.out.println(tmp_que);
                if(tmp_idx + lenth == t.length())  {
                    que.clear();
                    tmp_que.clear();
                    Flag = true;
                    break;
                }
                if(!visited[tmp_idx + lenth]){
                    visited[tmp_idx + lenth] = true;
                    tmp_que.add(tmp_idx + lenth);
                }
            }
            //System.out.println(tmp_que);
            if(que.isEmpty()) {
                answer++;

                que.addAll(tmp_que);
                tmp_que.clear();
            }
        } while(!que.isEmpty());
        if(!Flag) answer = -1;


        System.out.println("answer: " +answer);
    }

}
