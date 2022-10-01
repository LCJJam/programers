package kakao_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LockAndKey {
    public static void main(String[] args) {
        boolean answer = false;
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int len = key.length;
        List<Integer[]> lock_lst = new ArrayList<>();
        List<Integer[]> key_lst = new ArrayList<>();
        List<Integer[]> key_90_lst = new ArrayList<>();
        List<Integer[]> key_180_lst = new ArrayList<>();
        List<Integer[]> key_270_lst = new ArrayList<>();

        for(int i=0 ;i<len ;i++){
            for(int j=0;j<len;j++){
                if(key[i][j] == 1) key_lst.add(new Integer[]{i,j});
                if(key[len-j-1][i] == 1) key_90_lst.add(new Integer[]{i,j});
                if(key[len-i-1][len-j-1] == 1) key_180_lst.add(new Integer[]{i,j});
                if(key[j][len-i-1] == 1) key_270_lst.add(new Integer[]{i,j});

                if(lock[i][j] == 0) lock_lst.add(new Integer[]{i,j});
            }
        }
        for(Integer[] a : lock_lst){
            System.out.println(Arrays.toString(a));
        }

        for(int[] a : lock){
            for(int b : a){
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println();

        for(Integer[] a : key_lst){
            System.out.print(Arrays.toString(a) + " ");
        }
        System.out.println();
        for(Integer[] a : key_90_lst){
            System.out.print(Arrays.toString(a) + " ");
        }
        System.out.println();
        for(Integer[] a : key_180_lst){
            System.out.print(Arrays.toString(a) + " ");
        }
        System.out.println();
        for(Integer[] a : key_270_lst){
            System.out.print(Arrays.toString(a) + " ");
        }
        System.out.println();

        int mv_x = lock_lst.get(0)[0] - key_90_lst.get(0)[0];
        int mv_y = lock_lst.get(0)[1] - key_90_lst.get(0)[1];
        System.out.println(mv_x + " : " + mv_y);
        boolean flag = false;
        for( int i=0;i<lock_lst.size();i++){
            if( lock_lst.get(i)[0] != key_90_lst.get(i)[0]+mv_x || lock_lst.get(i)[1] != key_90_lst.get(i)[1]+mv_y) {
                System.out.println(lock_lst.get(i)[0] + " : " + key_90_lst.get(i)[0] );
                System.out.println(lock_lst.get(i)[1] + " : " + key_90_lst.get(i)[1] );
                flag = true;
                break;
            }
        }
        System.out.println(flag);


        System.out.println(answer);
    }
}
