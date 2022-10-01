package All_Progeramers_Problem;

public class T20220721 {
    public static void main(String[] args) {
        int answer = 0;
        String[] lines1 = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };
        String[] lines = {
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"
                // 02.002  , 05.001
        }; // 1
        String[] lines3 = {
                "2016-09-15 00:00:00.000 3s"
        }; // 1

        String[] lines4 = {
                "2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"
        }; // 2
        String[] lines2 = {
                "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"
        }; // 7


        int len = 24*60*60*1000;
        int[] arr = new int[len];
        for(String s : lines){
            s = s.replaceAll("s","");
            String[] s_arr = new String[3];
            String[] s2_arr = new String[3];

            s_arr = s.split(" ");
            // 시분초
            s2_arr = s_arr[1].split(":");

            // 끝난 시간
            double end_times_sec = Double.parseDouble(s2_arr[2]);
            Double end_times_min = Double.parseDouble(s2_arr[1]);
            Double end_times_hour = Double.parseDouble(s2_arr[0]);
            int end_times = (int) ((( end_times_hour * 60 + end_times_min ) * 60 + end_times_sec ) * 1000);

            // 걸린 시간
            double during_times = Double.parseDouble(s_arr[2]);
            int during_time = (int) (during_times * 1000);
            //System.out.println("end_times:"+end_times);
            System.out.println("during_time:"+during_time);
            int start_times = 0;
            if(end_times - during_time >= 0) start_times = end_times - during_time + 1;
            for(int i = start_times ; i <= end_times+999 ; i++){
                arr[i] = arr[i] + 1 ;
            }
        }
        // 가장 큰값 비교
        for(int i=0;i<len ; i++){
            answer = Math.max(answer,arr[i]);
        }
        System.out.println(answer);

    }
}
