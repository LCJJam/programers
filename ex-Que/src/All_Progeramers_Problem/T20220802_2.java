package All_Progeramers_Problem;

public class T20220802_2 {
    public static long[] solution(int n, int z, int[][] roads, long[] queries) {
        long[] answer = new long[queries.length];

        for(long target : queries){

        }
        // 1.연결된 다른 도시로 가는 방법
        // 2.현재 도시에서 움직이지 않고 z원
        // 3.원하는 도시로 이동. 이때 돈은 받지 않음

        return answer;
    }
    public static void main(String[] args) {
        int n = 5; // 도시 숫자
        int z = 5; // 게임 상수 z원
        int[][] roads = {{1,2,3},{0,3,2}}; // { u , v , w } u -> v 까지 w 원
        long[] queries = {0,1,2,3,4,5,6}; // target 가격



        long[] answer = solution(n,z,roads,queries); // 최소 몇턴 , 안되면 -1
        long[] result = {0,-1,1,2,3,1,4};

        boolean flag = true;
        for(long a : result){
            for(long b : answer){
                if(a!=b){
                    flag = false;
                    break;
                }
            }
            if(!flag || answer.length == 0) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
