package All_Progeramers_Problem;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
 * 미로 탈출
 */
public class T20231026_2 {
    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};

        System.out.println(solution(maps));
    }

    private static int solution(String[] maps){
        int answer = 0;
        /*
         * S : 시작 지점
         * E : 출구
         * L : 레버
         * O : 통로
         * X : 벽
         */
        Node start = null;
        Node lever = null;
        Node end = null;
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length() ; j++){
                if(maps[i].charAt(j) == 'S') start = new Node(i,j,0);
                if(maps[i].charAt(j) == 'L') lever = new Node(i,j,0);
                if(maps[i].charAt(j) == 'E') end = new Node(i,j,0);
            }
        }

        int sl = minDist(maps,start,lever);
        int le = minDist(maps,lever,end);

        if(sl == -1 || le == -1) {
            return -1;
        } else {
            answer += sl + le;
        }
        // 1. S -> L
        // 2. L -> E

        // 시작점 -> 목적지 까지 최소 거리 구하는 함수. func()
        // func(1) + func(2)

        return answer;
    }

    private static int minDist(String[] maps, Node start, Node end){
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length() ; j++){
                if(maps[i].charAt(j) == 'X') visited[i][j] = true;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()){
            Node tmpNode = queue.poll();
            if(tmpNode.x == end.x && tmpNode.y == end.y) return tmpNode.len;
            // 상
            if(tmpNode.x != 0 && !visited[tmpNode.x - 1][tmpNode.y]){
                queue.add(new Node(tmpNode.x - 1,tmpNode.y,tmpNode.len + 1));
                visited[tmpNode.x - 1][tmpNode.y] = true;
            }
            // 하
            if(tmpNode.x != maps.length - 1 && !visited[tmpNode.x + 1 ][tmpNode.y]){
                queue.add(new Node(tmpNode.x + 1,tmpNode.y,tmpNode.len + 1));
                visited[tmpNode.x + 1 ][tmpNode.y] = true;
            }
            // 좌
            if(tmpNode.y != 0 && !visited[tmpNode.x][tmpNode.y - 1]){
                queue.add(new Node(tmpNode.x,tmpNode.y - 1,tmpNode.len + 1));
                visited[tmpNode.x][tmpNode.y - 1] = true;
            }
            // 우
            if(tmpNode.y != maps[0].length() - 1 && !visited[tmpNode.x][tmpNode.y + 1]){
                queue.add(new Node(tmpNode.x,tmpNode.y + 1,tmpNode.len + 1));
                visited[tmpNode.x][tmpNode.y + 1] = true;
            }
        }

        return -1;
    }

    private static class Node {
        int x ;
        int y ;
        int len ;
        public Node (int x, int y, int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}
