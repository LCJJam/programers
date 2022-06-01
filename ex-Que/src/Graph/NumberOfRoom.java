package Graph;

import java.util.*;

public class NumberOfRoom {
    public static void main(String[] args) {
        int[] arrows = { 6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0 } ;

        int answer = 0;

        Set<String> lineSet = new HashSet<String>();
        Set<String> pointSet = new HashSet<String>();
        int x = 0;
        int y = 0;
        pointSet.add("" + x+"|"+y);
        for (int i = 0; i < arrows.length; i++) {
            for(int j = 0; j < 2; j++){
                int vect = arrows[i];
                String start = ""+ x+"|"+y;

                if(vect<=1 || vect==7) y++;
                if(1<=vect && vect<=3) x++;
                if(3<=vect && vect<=5) y--;
                if(5<=vect && vect<=7) x--;
                String point = "" + x+"|"+y;
                String normalLine = start +"|" + point;
                String backLine =  point + "|" + start;
                System.out.println(normalLine);
                if(pointSet.contains(point)){
                    if(!lineSet.contains(normalLine)){

                        answer++;
                    }
                }
                pointSet.add(point);
                lineSet.add(normalLine);
                lineSet.add(backLine);
            }

        }

        System.out.println(answer);
    }
}
