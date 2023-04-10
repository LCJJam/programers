package All_Progeramers_Problem;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 * 코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT > 실패율
 */
public class FailRate {
    public static void main(String[] args) {
//        int N = 5;
////        int N = 4;
//        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
////        int[] stages = {4,4,4,4,4};
//        int[] answer = {};
//        // N 은 500 이하 자연수
//        // stages 길이는 200,000 이하
//        answer = new int[N];
//        double[] stage_Num = new double[N+2];
//        double[] stage_fail = new double[N+2];
//        int Challenger = stages.length;
//        for(int i=0;i<stages.length;i++){
//            stage_Num[stages[i]]++;
//        }
//        for(int i=1;i<=N;i++){
//            stage_fail[i] = stage_Num[i] / Challenger;
//            Challenger -= stage_Num[i];
//        }
//
//        Double[][] list = new Double[N][2];
//        for(int i=0;i<N;i++){
//            Double[] d = {(double)i+1, stage_fail[i+1]};
//            list[i] = d;
//        }
//
//        Arrays.sort(list, new Comparator<Double[]>() {
//            @Override
//            public int compare(Double[] o1, Double[] o2) {
//                if(o1[1] < o2[1]) {return 1;}
//                else if(o1[1] > o2[1]) {return -1;}
//                else {return o1[0].compareTo(o2[0]);}
//            }
//        });
//
//        int idx = 0;
//        for(Double[] a : list){
//            answer[idx] = a[0].intValue();
//            idx++;
//        }
//
//        System.out.println(Arrays.toString(answer));

        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//        int[] stages = {4,4,4,4,4};

        double[] stageNum = new double[N + 2];
        final int[] challenger = {stages.length};
        Arrays.stream(stages).forEach(stage -> stageNum[stage]++);

        double[] stageFail = new double[N + 1];
        IntStream.rangeClosed(1, N).forEach(stage -> {
            stageFail[stage] = stageNum[stage] / challenger[0];
            challenger[0] -= stageNum[stage];
        });

//        IntStream aa = IntStream.rangeClosed(1, N).filter(a -> a > 3);
//        aa.forEach(System.out::println);

        Integer[] answer = IntStream.rangeClosed(1, N).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(answer));
        Arrays.sort(answer, (o1, o2) -> {
            double fail1 = (o1 <= N) ? stageFail[o1] : 0;
            double fail2 = (o2 <= N) ? stageFail[o2] : 0;
            if (fail1 != fail2) {
                return Double.compare(fail2, fail1);
            } else {
                return Integer.compare(o1, o2);
            }
        });

        System.out.println(Arrays.toString(answer));
    }
}
