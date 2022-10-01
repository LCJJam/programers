package All_Progeramers_Problem;

import java.util.*;

public class T20220807 {
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
    public static long solution(int[][] rectangles) {
        long answer = -1;
        TreeSet<Integer> xs = new TreeSet<>();
        List<Edge> edges = new ArrayList<>();
        for (int[] r : rectangles) {
            xs.add(r[0]);
            xs.add(r[2]);
            edges.add(new Edge(r[0], r[2], r[1], 1));
            edges.add(new Edge(r[0], r[2], r[3], -1));
        }
        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                return e1.h - e2.h;
            }
        });
        long[] xarr = new long[xs.size()];
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (Integer x : xs) {
            map.put(x, index);
            xarr[index++] = x;
        }
        SegmentTree st = new SegmentTree(xarr);
        long sum = 0L;
        for (int i = 0; i < edges.size() - 1; i++) {
            Edge e1 = edges.get(i), e2 = edges.get(i + 1);
            st.incRange(map.get(e1.l), map.get(e1.r) - 1, e1.f);
            sum += (long)(e2.h - e1.h) * (long)st.getCover();
        }
        return sum;
    }

    static class Edge {
        private int l, r, h, f;
        public Edge(int l, int r, int h, int f) {
            this.l = l;
            this.r = r;
            this.h = h;
            this.f = f;
        }
    }

    static class SegmentTree {
        private long[] arr;
        private long[] cover;
        private int[] layer;

        public SegmentTree(long[] array) {
            arr = Arrays.copyOf(array, array.length);
            int height = (int) Math.ceil(Math.log(array.length) / Math.log(2.0));
            int max_size = 2 * (int) Math.pow(2, height);
            layer = new int[max_size];
            cover = new long[max_size];
        }

        public long getCover() {
            return cover[1];
        }

        // range increase
        public void incRange(int from, int to, int val) {
            incRange(from, to, val, 1, 0, arr.length - 1);
        }

        private void incRange(int from, int to, int val, int v, int s, int e) {
            if (to < s || from > e || s > e || from > to) return;
            if (from <= s && to >= e) {
                layer[v] += val;
                cover[v] = getCover(v, s, e);
            } else {
                int mid = (s + e) / 2;
                incRange(from, to, val, 2 * v, s, mid);
                incRange(from, to, val, 2 * v + 1, mid + 1, e);
                cover[v] = getCover(v, s, e);
            }
        }

        private long getCover(int v, int s, int e) {
            if (layer[v] > 0) return arr[e + 1] - arr[s];
            if (s == e) return 0;
            return cover[2 * v] + cover[2 * v + 1];
        }
    }
}
