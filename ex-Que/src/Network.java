import java.util.*;

public class Network {
    static boolean[] check = new boolean[200];
    static int answer = 0;
    public static void main(String[] args) {



        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int n2 = 3;
        int[][] computers_2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        int n3 = 3;
        int[][] computers_3 = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};

        int n4 = 4;
        int[][] computers_4 = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};

        for(int i =0 ; i < n ; i ++){
            if(!check[i]){
                dfs(i,n,computers_3);
                answer++;
            }
        }

        System.out.println(answer);

    }

    public static void dfs(int idx, int num_col, int[][] computer){
        if(!check[idx]) {
            check[idx] = true;
            for (int i = idx+1; i < num_col; i++) {
                if (computer[idx][i] == 1) {
                    dfs(i, num_col, computer);
                }
            }
        } else {
            answer -= 1;
        }
    }
}
