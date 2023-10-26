package All_Progeramers_Problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 이모티콘 할인행사
 * https://school.programmers.co.kr/learn/courses/30/lessons/150368
 */

public class T20231025_2 {
    public static void main(String[] args) {

        // users[i][0] : n % 이상 할인하는 모든 이모티콘 구매
        // users[i][1] : 구매 이모티콘이 n 원 이상이 되면 구매 취소하고 구독

//        int[][] users = {{40,10000},{25,10000}};
//        int[] emoticons = {7000, 9000};

        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};

        System.out.println(Arrays.toString(solution(users , emoticons)));
    }


    private static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        // 1.이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
        // 이모티콘 할인 가짓수 = 4^n -> max : 4^7
        // 유저 수 : 최대 100
        // 최대 연산 : 100 * 4^7
        Queue<Node> node = new LinkedList<>();
        node.add(new Node(new int[users.length],0));

        int maxSubscribe = 0;
        int maxPrice = 0;

        while (!node.isEmpty()){
            Node tmpNode = node.poll();
            if(tmpNode.depth == emoticons.length) {
                int subscribe = 0;
                int price = 0;
                for(int i = 0; i < tmpNode.user.length; i++) {
                    if(tmpNode.user[i] >= users[i][1]) {
                        subscribe++;
                    } else {
                        price += tmpNode.user[i];
                    }
                }

                if(subscribe > maxSubscribe) {
                    maxSubscribe = subscribe;
                    maxPrice = price;
                } else if (subscribe == maxSubscribe) {
                    maxPrice = Math.max(maxPrice, price);
                }

                continue;
            }

            for(int k = 0; k < 4 ; k++){
                int[] arr = tmpNode.user.clone();
                for(int i = 0; i < users.length; i++) {
                    if(users[i][0] <= 10 * (k+1))
                        arr[i] += ( emoticons[tmpNode.depth] * 0.1 * (9 - k) );
                }
                node.add(new Node(arr , tmpNode.depth + 1));
            }

        }

        answer[0] = maxSubscribe;
        answer[1] = maxPrice;

        return answer;
    }

    private static class Node {
        private final int[] user;
        private final int depth;

        public Node(int[] user, int depth) {
            this.user = user;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return Arrays.toString(user);
        }
    }
}
