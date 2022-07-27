package All_Progeramers_Problem;

public class T20220728 {
    static int N;
    static int P;
    static int Q;
    public static void main(String[] args) {
        int[][] land = {{4, 4, 3}, {3, 2, 2}, { 2, 1, 0 }};
        P = 5;
        Q = 3;
        long answer = 0;
        N = land.length;
        long end = land[0][0];
        long start = land[0][0];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(land[i][j] > end)
                    end = land[i][j];
                if(land[i][j] < start)
                    start = land[i][j];
            }
        }
        long mid;
        while(start <= end){

            mid = (start + end)/ 2;

            long leftCost = calculateCost(land, mid);
            long rightCost = calculateCost(land,mid+1);
            if(leftCost > rightCost){
                answer = rightCost;
                start = mid+1;
            }
            else{
                answer = leftCost;
                end = mid-1;
            }

        }
        System.out.println(answer);
    }
    static long calculateCost(int[][] land ,long height){
        System.out.println(height);
        long cost = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(land[i][j] > height){
                    cost += (land[i][j] - height) * Q;
                }
                else{
                    cost += (height - land[i][j]) * P;
                }
            }
        }
        return cost;
    }
}
