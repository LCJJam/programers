package All_Progeramers_Problem;

import java.util.*;

public class T20220802 {
    public static long solution(int[][] rectangles) {
        long answer = 0;

        ArrayList<Integer> x_set = new ArrayList<>();
        ArrayList<int[]> y_set = new ArrayList<>();
        for(int[] a : rectangles){
            if(!x_set.contains(a[0])) x_set.add(a[0]);
            if(!x_set.contains(a[2])) x_set.add(a[2]);
        }
        Collections.sort(x_set);
        //x_set.sort(Integer::compareTo);
        Arrays.sort(rectangles,Comparator.comparingInt(o1 -> o1[0]));
        System.out.println(rectangles[0][0] + " + " + rectangles[0][2]);
        System.out.println(rectangles[1][0] + " + " + rectangles[1][2]);
        for(int i = 0; i < x_set.size()-1; i++){
            y_set.clear();
            for(int[] b : rectangles){
                if(x_set.get(i+1) < b[0]) break;
                if(  b[0] <= x_set.get(i)  &&  x_set.get(i+1) <= b[2]){
                    y_set.add(new int[]{b[1],b[3]});
                }
            }
            int y_val = merge(y_set);
            answer += ((long)(x_set.get(i+1)-x_set.get(i)) * (long)y_val);
            System.out.println(y_set);
        }

        return answer;
    }
    public static int merge (ArrayList<int[]> intArr){
        Collections.sort(intArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0],b[0]);
            }
        });
        int start = 0;
        int end = 0;
        int distance = 0;
        for(int[] a : intArr){
            if(a[0] < end){
                if(a[1] > end){
                    end = a[1];
                }
            } else {
                distance += (end - start);
                start = a[0];
                end = a[1];
            }
        }
        distance = distance + end - start ;
        return distance;
    }

    public static void main(String[] args) {


        int[][] rectangles = {{0, 1, 4, 4},{3, 1, 5, 3}};
        int[][] rectangles2 = {{1, 1, 6, 5}, {2, 0, 4, 2}, {2, 4, 5, 7}, {4, 3, 8, 6}, {7, 5, 9, 7}};
        long answer = solution(rectangles);
        long answer1 = 14;
        System.out.println(answer == answer1);

        answer = solution(rectangles2);
        long answer2 = 38;
        System.out.println(answer == answer2);
    }


}
