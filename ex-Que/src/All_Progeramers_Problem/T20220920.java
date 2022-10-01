package All_Progeramers_Problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
 https://school.programmers.co.kr/learn/courses/30/lessons/64063?language=java
 */
public class T20220920 {
    static HashMap<Long, Long> map = new HashMap<>();
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1,3,4,1,3,1};
        /*
        int len = room_number.length;
        long[] answer = new long[len];
        Map<Long,Long> roomMap = new HashMap<>();
        int i = 0;
        for(long target : room_number){
            long r = roomMap.getOrDefault(target,Long.valueOf(0));
            while(r != (long)0){
                target++;
                r = roomMap.getOrDefault(target,Long.valueOf(0));
            }
            roomMap.put(target,target);
            answer[i] = target;
            i++;
        }
        */
        long[] answer = new long[room_number.length];

        for(int i = 0; i < room_number.length; i++){
            answer[i] = findEmptyRood(room_number[i]);
        }
        System.out.println(Arrays.toString(answer));
    }
    public static long findEmptyRood(long request){
        if(!map.containsKey(request)){
            map.put(request, request+1);
            return request;
        }

        long next_room = map.get(request);
        long empty_room = findEmptyRood(next_room);
        map.put(request, empty_room);
        return empty_room;
    }
}
