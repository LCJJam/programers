package All_Progeramers_Problem;

import java.util.LinkedList;
import java.util.Queue;

public class T20220714 {
    public static void main(String[] args) {
        int answer = 0;
        int n = 15;
        int arr[][] = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}};
        int len = arr.length;
        int fstArr[][] = new int[3][len];
        for(int j=0;j<len;j++){
            for(int i =0;i<len; i++){
                System.out.print(arr[i][j]);
                if(arr[i][j] != 0 && fstArr[0][j]==0){
                    fstArr[0][j] = arr[i][j];
                    fstArr[1][j] = i;
                    fstArr[2][j] = j;
                    break;
                }
            }
            System.out.println();
        }

        // 1-3,4
        // 2-2,3
        // 3-1
        Queue<Integer> a = new LinkedList<>();
        for(int i=0 ; i<len-1; i++){
            a.add(i);
        }
        while(!a.isEmpty()){
            int idx = a.poll();
            if(fstArr[0][idx] != fstArr[0][idx+1]){
                a.add(idx);
            } else if(idx < len-2 && fstArr[1][idx] > 1){
                int num = fstArr[0][idx];
                int i = fstArr[1][idx];
                int j = fstArr[2][idx];
                if(arr[i][j+1] == num && arr[i-1][j+1] == num && arr[i-2][j+1] == num){
                    arr[i][j+1] = 0; arr[i-1][j+1] = 0;
                    answer++;
                } else if(arr[i][j+1] == num && arr[i-1][j+1] == num && arr[i][j+2] == num) {
                    answer++;
                } else if(arr[i][j+1] == num && arr[i][j+2] == num && arr[i-1][j+2] == num){
                    answer++;
                } else if(arr[i+1][j] == num && arr[i+2][j] == num && arr[i+2][j+1] == num){
                    answer++;
                } else if(arr[i+1][j] == num && arr[i+1][j+1] == num && arr[i+1][j+2] == num){
                    answer++;
                }
            } else {

            }
        }
        answer +=1;

        System.out.println(answer);
    }
}
