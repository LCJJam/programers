package Graph;

import java.util.*;

public class MostFarNode {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}} ;

        List<List<Integer>> graph = new ArrayList();
        int answer = 0;
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        boolean[] visit = new boolean[n + 1];
        Integer[] count = new Integer[n + 1];
        Arrays.fill(count, 0);
        visit[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (int g : graph.get(node)) {
                if (!visit[g]) {
                    visit[g] = true;
                    count[g] = count[node] + 1;
                    // count[g] = Math.min(count[g], node.count + 1);
                    queue.add(g);
                }
            }
        }
        int max = 0;
        for (int i = 2; i <= n; i++) {
            if (max < count[i]) {
                max = count[i];
                answer = 1;
            } else if (max == count[i]) {
                answer++;
            }
        }
        System.out.println(answer);



    }
}
