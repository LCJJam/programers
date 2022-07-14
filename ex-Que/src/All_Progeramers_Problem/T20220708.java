package All_Progeramers_Problem;


public class T20220708 {
    public static void main(String[] args) {
        int answer = 0;
        int[][] a = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        for(int i=1;i < a.length ; i++){
            int[] b = a[i];
            for(int j=0;j < b.length ; j++){
                if(j != 0 && j < b.length-1){
                    b[j] = b[j] + Math.max(a[i-1][j-1],a[i-1][j]);
                } else if (j == 0) {
                    b[j] = b[j] + a[i-1][0];
                } else {
                    b[j] = b[j] + a[i-1][j-1];
                }
                System.out.print(b[j] + " ");
            }
            a[i] = b;
            System.out.println();
        }
        long b = 3;
        System.out.println(b == 3);
        for(int c : a[a.length-1]){
            answer = Math.max(answer ,c );
        }
    }
}
