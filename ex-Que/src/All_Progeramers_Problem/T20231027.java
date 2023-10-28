package All_Progeramers_Problem;

import javax.xml.stream.events.Characters;
import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 * 무인도 여행
 */
public class T20231027 {

    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};

        System.out.println(Arrays.toString(solution(maps)));
    }

    private static int[] solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        boolean[][] visited = new boolean[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(maps[i].charAt(j) == 'X') visited[i][j] = true;
            }
        }

        int mapNum = 0;
        boolean visitedOnce = false;
        Queue<Node> queue = new LinkedList<>();
        int[] list = new int[row * col / 2];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(!visited[i][j]) {
                    visitedOnce = true;
                    queue.add(new Node(i,j,mapNum));

                    while (!queue.isEmpty()) {
                        Node tmpNode = queue.poll();

                        visited[tmpNode.x][tmpNode.y] = true;
                        list[mapNum] += Character.getNumericValue(maps[tmpNode.x].charAt(tmpNode.y));

                        // 상
                        if(tmpNode.x != 0 && !visited[tmpNode.x - 1][tmpNode.y]){
                            queue.add(new Node(tmpNode.x - 1,tmpNode.y,tmpNode.mapNum));
                            visited[tmpNode.x - 1][tmpNode.y] = true;
                        }
                        // 하
                        if(tmpNode.x != maps.length - 1 && !visited[tmpNode.x + 1 ][tmpNode.y]){
                            queue.add(new Node(tmpNode.x + 1,tmpNode.y,tmpNode.mapNum));
                            visited[tmpNode.x + 1 ][tmpNode.y] = true;
                        }
                        // 좌
                        if(tmpNode.y != 0 && !visited[tmpNode.x][tmpNode.y - 1]){
                            queue.add(new Node(tmpNode.x,tmpNode.y - 1,tmpNode.mapNum));
                            visited[tmpNode.x][tmpNode.y - 1] = true;
                        }
                        // 우
                        if(tmpNode.y != maps[0].length() - 1 && !visited[tmpNode.x][tmpNode.y + 1]){
                            queue.add(new Node(tmpNode.x,tmpNode.y + 1,tmpNode.mapNum));
                            visited[tmpNode.x][tmpNode.y + 1] = true;
                        }
                    }
                    mapNum++;
                }
            }
        }
        int[] arr = !visitedOnce ? new int[]{-1} : Arrays.copyOfRange(list,0,mapNum);
        Arrays.sort(arr);

        return arr;
    }

    private static class Node {
        int x;
        int y;
        int mapNum;
        public Node (int x , int y, int mapNum){
            this.x = x;
            this.y = y;
            this.mapNum = mapNum;
        }

        @Override
        public String toString(){
            return "x : "+x + "  y :" +y + "  mapNum :" + mapNum;
        }
    }
}
