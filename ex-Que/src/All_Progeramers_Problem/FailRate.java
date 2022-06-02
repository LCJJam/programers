package All_Progeramers_Problem;

import java.util.Arrays;
import java.util.Comparator;

public class FailRate {
    public static void main(String[] args) {
        //int N = 5;
        int N = 4;
        //int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] stages = {4,4,4,4,4};
        int[] answer = {};
        // N 은 500 이하 자연수
        // stages 길이는 200,000 이하
        answer = new int[N];
        double[] stage_Num = new double[N+2];
        double[] stage_fail = new double[N+2];
        int Challenger = stages.length;
        for(int i=0;i<stages.length;i++){
            stage_Num[stages[i]]++;
        }
        for(int i=1;i<=N;i++){
            stage_fail[i] = stage_Num[i] / Challenger;
            Challenger -= stage_Num[i];
        }

        Double[][] list = new Double[N][2];
        for(int i=0;i<N;i++){
            Double[] d = {(double)i+1, stage_fail[i+1]};
            list[i] = d;
        }

        Arrays.sort(list, new Comparator<Double[]>() {
            @Override
            public int compare(Double[] o1, Double[] o2) {
                if(o1[1] < o2[1]) {return 1;}
                else if(o1[1] > o2[1]) {return -1;}
                else {return o1[0].compareTo(o2[0]);}
            }
        });

        int idx = 0;
        for(Double[] a : list){
            answer[idx] = a[0].intValue();
            idx++;
        }

        System.out.println(Arrays.toString(answer));
    }
}
