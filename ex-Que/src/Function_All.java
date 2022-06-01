import java.util.*;

public class Function_All {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(3);
        q.poll();


        String[] A = new String[3];
        Arrays.fill(A,"");
        String B = "1234567";
        System.out.println(B.substring(3)); // 4567
        System.out.println(B.substring(1,4)); // 234

        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i=0;i<clothes.length;i++) {
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
        }
        System.out.println(hm);


        int[][] jobs = {{7,2,3},{2,3,4},{1,5,6}};
        // 이차 배열 중 N번쨰 값 비교하여 정렬
        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] <= o2[0]){
                    return -1;
                }
                return 1;
            }
        });
        for (int[] a : jobs){
            System.out.println(Arrays.toString(a));
        }

        // 내림차순 Queue 정렬
        PriorityQueue<Integer> revQue = new PriorityQueue<>(Comparator.reverseOrder());

        // 배열 Queue 적재 시 N번째 값 비교하여 우선순위 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]){
                    return -1;
                }
                return 1;
            }
        });
        int[] a = {1,2,3};
        queue.offer(a);
        queue.add(a);
        //System.out.println(Arrays.toString(queue.peek()));

        String path = "EEESSSDD";
        //System.out.println(path.length());
        ArrayList<String> str = new ArrayList<>();
        String st = "abcde";
        //System.out.println(st.substring(2));
        //System.out.println(st.indexOf('c',9));
        str.add(st);
        char ch = 'k';
        st.equals(ch);
        st.substring(0);
        //System.out.println("aaabbb".substring(0,1));

        String[][] var = {{"template","{state}"},{"state","{templates}"}};
        Map<String,String> map = new HashMap<>();
        for(String[] stt : var){
            map.put(stt[0],stt[1]);
        }

        for(String[] ps : var){
            String cmp = ps[1];
            String cmp2 = cmp;
            while(cmp.indexOf('{') > -1){
                System.out.println("before cmp : "+cmp);
                String del = cmp.substring(1,cmp.length()-1);
                System.out.println("del: " + del);
                cmp = map.get(del);
                System.out.println("cmp: "+cmp);
                if(cmp == cmp2){
                    break;
                }
            }
            map.put(ps[0],cmp);
        }
        ArrayList<String > ass = new ArrayList<>();
        ass.add("k");
        //System.out.println(ass.get(1));
        //System.out.println(ass.contains("k"));

        String spc = "{kk}";

        //System.out.println(spc.substring(1,spc.length()-1));

        //System.out.println(map.get("a"));
        //System.out.println(map.get("b"));
        //System.out.println(map.get("c"));

        map.put("a","C");
        //System.out.println(map.get("a"));

    }
}
