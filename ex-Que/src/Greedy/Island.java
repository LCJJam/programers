package Greedy;
import java.util.*;
public class Island {
    public static void main(String[] args) {
        //int n = 4;
        //int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};



        int n = 5;
        //int[][] costs = {{0, 1, 1}, {3, 1, 1}, {0, 2, 2}, {0, 3, 2}, {0, 4, 100}};
        int[][] costs = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}};
        int answer = 0;
        int[] parent = new int[n];
        for(int a=0;a<parent.length;a++){
            parent[a] = a;
        }
        int idx = 0;

        Integer[][] Icost = new Integer[costs.length][3];
        for(Integer[] a : Icost){
            Icost[idx] = Arrays.stream(costs[idx]).boxed().toArray(Integer[]::new);
            idx++;
        }

        Arrays.sort(Icost,new Comparator<Integer[]>() {
                    @Override
                    public int compare(Integer[] o1, Integer[] o2) {
                        return o1[2].compareTo(o2[2]);
                    }
                });

        for(Integer[] a : Icost){
            int m1,m2;
            if(a[0] < a[1]) { m1 = a[0]; m2 = a[1];}
            else { m1 = a[1]; m2 = a[0];}
            if(findParent(parent,m1) != findParent(parent,m2)){
                parent[findParent(parent,m2)] = findParent(parent,m1);
                answer += a[2];
            }
        }




        for(Integer[] a : Icost){
            System.out.println(Arrays.toString(a));
        }
        System.out.println(answer);
    }
    public static int findParent(int[] parents, int target){
        if(parents[target] == target ){
            return target;
        }
        return findParent(parents,parents[target]);
    }
}
