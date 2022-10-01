package All_Progeramers_Problem;

import java.util.ArrayList;
import java.util.Arrays;

public class T20220715 {
    public static void main(String[] args) {
        int[] a = {1,1,1,1,1,1,2,5,8,2,1,1,4,8,8,8,12,6,6};
        int[] s = {4,3,1,5,6};
        int[] answer = new int[s.length];

        int idx=0;
        int s_idx=0;
        for(int s_num : s){

            int[] tmp = new int[s_num];
            ArrayList<Integer> tmp_ = new ArrayList<>();
            for(int i=idx ; i < idx+s_num ; i++){
                tmp[i-idx] = a[i];
                tmp_.add(a[i]);
            }
            //int cnt = fnc(tmp,1,tmp[0]);
            System.out.println("start :" + tmp_);
            int cnt = fnc_(tmp_,0,0,s_num);
            idx+=s_num;
            answer[s_idx] = cnt+1;
            s_idx++;
            System.out.println();
        }

        int[] ans = {6,3,1,5,9};
        for(int x : answer){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println(Arrays.equals(answer,ans));
    }

    public static int fnc_ (ArrayList<Integer> tmp_, int index, int i, int end){
        if(i == end) {
            return 0;
        }
        int sum=0;
        ArrayList<Integer> tmp2_ = new ArrayList<>(tmp_);
        if(index == 0) {
            return sum+=fnc_(tmp_,index+1,i+1,end);
        } else if(tmp_.get(index-1) == tmp_.get(index)){
            Integer ridx= tmp_.remove(index);
            tmp_.set(index-1,ridx*2);
            sum= 1 + fnc_(tmp_,index-1,i,end);
        }
        sum+=fnc_(tmp2_,index+1,i+1,end);
        System.out.println(tmp2_ + " : " + sum);
        return sum;
    }

    public static int fnc (int[] tmp, int index, int left){
        if(index == tmp.length) return 1;
        int sum=0;
        if(left == tmp[index]){
            sum+=fnc(tmp,index,left*2);
        }
        sum+=fnc(tmp,index+1,left);

        return sum;
    }
}
