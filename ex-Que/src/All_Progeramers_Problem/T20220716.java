package All_Progeramers_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class T20220716 {
    static class Node{
        int to;
        int cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static int answer;
    static List<Node>[] list;
    static int[] cost;
    public static void main(String[] args) {
        // a-> b , b -> c , a-> c
        int n = 4;
        int[][] edges = {{1,2},{2,3},{3,4}};
        // int MAX = -1;
        // 비교 : n 개중 3개를 골라서, 그중 가장 큰 평균 값을 구해라.
        // nC3 , f(a,b,c) = ( a->b + b->c + a->c ) 주어진 식을 가지고 vertax 간에 거리를 구해야함.
        list = new ArrayList[n+1];
        cost = new int[n+1];
        for(int i=1; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }
        // 1-> 5 -> 1(x),2->5(x),3->5(x),4->5(x)

        for(int[] arr_dis : edges){
            int u = arr_dis[0];
            int v = arr_dis[1];
            //방문 했으면 다시
            list[u].add(new Node(v,1));
            list[v].add(new Node(u,1));
            System.out.println(list[u].get(0).to);
        }


    }
    static void dfs(int to, int pa, int from, int cost) {
        if(to == from) {
            answer = cost;
        }
        for(Node nxt : list[to]) {
            if(nxt.to != pa) {
                dfs(nxt.to, to, from, cost+nxt.cost);
            }
        }
    }
}
