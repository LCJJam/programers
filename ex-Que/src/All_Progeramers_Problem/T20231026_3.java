package All_Progeramers_Problem;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651
 * 호텔 대실
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class T20231026_3 {
    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(solution(book_time));
    }

    private static int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time,
                (o1, o2) -> o1[0].compareTo(o2[0])
        );
        System.out.println(Arrays.deepToString(book_time));
        Queue<Time> queue = new PriorityQueue<>();

        int maxQueSize = 1;

        for(String[] s : book_time){
            int startTime = Integer.parseInt(s[0].split(":")[0]) * 60 + Integer.parseInt(s[0].split(":")[1]);
            int endTime = Integer.parseInt(s[1].split(":")[0]) * 60 + Integer.parseInt(s[1].split(":")[1]);

            if(queue.isEmpty()) {
                queue.add(new Time(startTime, endTime));
            } else {
                Time t = queue.peek();
                if(t.end + 10 > startTime) {
                    queue.add(new Time(startTime, endTime));
                    maxQueSize = Math.max(maxQueSize , queue.size());
                } else {
                    queue.poll();
                    queue.add(new Time(startTime, endTime));
                }
            }

        }


        return maxQueSize;
    }

    private static class Time implements Comparable<Time> {
        int start;
        int end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time t) {
            return end - t.end;
        }

        @Override
        public String toString(){
            return "start : " + start + " , end : " + end;
        }
    }
}
