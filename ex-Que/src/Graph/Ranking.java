package Graph;

import java.util.*;

public class Ranking {
    static int n = 5;
    public static void main(String[] args) {

        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        List<List<Integer>> left_graph = new ArrayList();
        List<List<Integer>> right_graph = new ArrayList();
        int answer = 0;
        for (int i = 0; i < n + 1; i++) {
            left_graph.add(new ArrayList<>());
            right_graph.add(new ArrayList<>());
        }
        for (int i = 0; i < results.length; i++) {
            right_graph.get(results[i][0]).add(results[i][1]);
            left_graph.get(results[i][1]).add(results[i][0]);
        }
        System.out.println("### Graph ###");
        System.out.println(left_graph);
        System.out.println(right_graph);
        System.out.println("#############");

        Queue<Integer> queue = new LinkedList<>();

        Integer[] l_cnt = new Integer[n+1];
        Integer[] r_cnt = new Integer[n+1];
        boolean[] l_chk = new boolean[n+1];
        boolean[] r_chk = new boolean[n+1];


        for(int i=1 ; i <= n ; i++){
            int cnt=0;
            Arrays.fill(l_chk,false);
            Arrays.fill(r_chk,false);
            l_chk = dfs(left_graph,i,l_chk);
            r_chk = dfs(right_graph,i,r_chk);
            System.out.println("a:" + Arrays.toString(l_chk));
            System.out.println("b:" + Arrays.toString(r_chk));
            for(int j=1 ; j <= n ; j++){
                if(l_chk[j]) cnt++;
                if(r_chk[j]) cnt++;
            }
            if(cnt == n+1) answer++;
//            HashSet<Integer> left = new HashSet<>();
//            HashSet<Integer> right = new HashSet<>();
//            int size = 0;
//            queue.add(i);
//            while(!queue.isEmpty()){
//                Integer node = queue.poll();
//                if(!l_chk[node]){
//                    for(int tag : left_graph.get(node)){
//                        queue.add(tag);
//                        System.out.println(i + " : left : " + left);
//                        left.add(tag);
//                    }
//                }
//            }
//            queue.add(i);
//            while(!queue.isEmpty()){
//                Integer node = queue.poll();
//                for(int tag : right_graph.get(node)){
//                    queue.add(tag);
//                    System.out.println(i + " : right : " + right);
//                    right.add(tag);
//                }
//            }
//            System.out.println(i + " : left : " + left.size() + " : right : " + right.size());
//            size = left.size() + right.size();
//            if(size == n-1 ) answer++;
        }

        System.out.println(answer);
    }

    public static boolean[] dfs(List<List<Integer>> graph, int node, boolean[] chk){
        //System.out.println(node + ":" + chk);
        List<Integer> lst = graph.get(node);
        chk[node] = true;
        //System.out.println(Arrays.toString(chk) + graph);
        if(lst.size() != 0){
            for(int i : lst){
                if(!chk[i]){
                    chk = dfs(graph, i, chk);
                }
            }
            return chk;
        } else {
            return chk;
        }
    }
}
