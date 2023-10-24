package All_Progeramers_Problem;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 리코쳇 로봇
 * https://school.programmers.co.kr/learn/courses/30/lessons/169199
 */
public class T20231025 {
    public static void main(String[] args) {

        // R : Robot , G : Goal , D : 장애물
        String[] board = {
                "...D..R",
                ".D.G...",
                "....D.D",
                "D....D.",
                "..D...."};

        System.out.println(solution(board));

    }

    private static int solution(String[] board) {
        int lenX = board.length;
        int lenY = board[0].length();
        boolean[][] visited = new boolean[lenX][lenY];

        Queue<Node> pq = new LinkedList<>();

        // 시작점 삽입
        for(int i = 0; i < lenX ; i++) {
            if(board[i].indexOf('R') >= 0) {
                pq.add(new Node(i, board[i].indexOf('R'),0)) ;
                visited[i][board[i].indexOf('R')] = true;
            }
        }

        // 상하좌우 이동 하려고 할때, 벽,장애물에 부딪히면 stop , visited 마킹
        while(!pq.isEmpty()) {

            Node tmpNode = pq.poll();
            // 상
            int x = tmpNode.x;
            int y = tmpNode.y;
            int dist = tmpNode.dist;
            System.out.println(x + ","+ y + "  dist:" + dist);
            while(x > 0 && board[x-1].charAt(y) != 'D' ) {
                --x;
            }
            if(board[x].charAt(y) == 'G') return dist+1;
            if(!visited[x][y]) {
                pq.add(new Node(x, y,dist+1));
                visited[x][y] = true;
            }
            // 하
            x = tmpNode.x;
            while(x < lenX - 1 && board[x+1].charAt(y) != 'D') {
                ++x;
            }
            if(board[x].charAt(y) == 'G') return dist+1;
            if(!visited[x][y]) {
                pq.add(new Node(x, y,dist+1));
                visited[x][y] = true;
            }

            // 좌
            x = tmpNode.x;
            while(y < lenY - 1 && board[x].charAt(y+1) != 'D') {
                ++y;
            }
            if(board[x].charAt(y) == 'G') return dist+1;
            if(!visited[x][y]) {
                pq.add(new Node(x, y,dist+1));
                visited[x][y] = true;
            }

            // 우
            y = tmpNode.y;
            while(y > 0 && board[x].charAt(y-1) != 'D' ) {
                --y;
            }
            if(board[x].charAt(y) == 'G') return dist+1;
            if(!visited[x][y]) {
                pq.add(new Node(x, y,dist+1));
                visited[x][y] = true;
            }


        }
        return -1;
    }

    private static class Node {
        int x;
        int y;
        int dist;
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
