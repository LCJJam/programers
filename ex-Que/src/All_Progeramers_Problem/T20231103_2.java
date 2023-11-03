package All_Progeramers_Problem;

import java.util.*;

/*
 * 빛의 경로 사이클
 * https://school.programmers.co.kr/learn/courses/30/lessons/86052
 */
public class T20231103_2 {
    public static void main(String[] args) {
        String[] grid = {"SL","LR"};

        System.out.println(Arrays.toString(solution(grid))); // { 16 }
    }


    private static int[] solution(String[] grid) {
        List<Integer> list = new ArrayList<>();

        int row = grid.length;
        int col = grid[0].length();
        boolean[][][] visited = new boolean[row][col][4];
        int[] dx = {0, 1 , 0 , -1};
        int[] dy = {1, 0 , -1 , 0};

        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < row ; i++){
            for(int j = 0; j < col ; j++){
                for(int k = 0; k < 4; k++){
                    if(!visited[i][j][k]){
                        // 초기값 설정
                        Node node = new Node(i,j,k,0);
                        queue.add(node);
                        // 순회
                        while(!queue.isEmpty()){
                            Node tmpNode = queue.poll();

                            int x = tmpNode.x;
                            int y = tmpNode.y;
                            int dir = tmpNode.dir;
                            int dist = tmpNode.dist;


                            if(!visited[x][y][dir]){
                                visited[x][y][dir] = true;

                                switch (grid[x].charAt(y)){
                                    case 'R':
                                        dir = (( dir + 1 ) % 4);
                                        break;

                                    case 'L':
                                        dir = (( dir + 3 ) % 4);
                                        break;
                                }

                                x = x + dx[dir];
                                y = y + dy[dir];

                                if(x < 0) {
                                    x = row - 1;
                                } else if (x == row) {
                                    x = 0;
                                }

                                if(y < 0) {
                                    y = col - 1;
                                } else if (y == col) {
                                    y = 0;
                                }

                                queue.add(new Node(x , y , dir , dist + 1));

                            } else {
                                list.add(dist);
                            }
                        }
                    }
                }
            }
        }

        return list
                .stream()
                .mapToInt(i -> i)
                .sorted()
                .toArray();
    }

    private static class Node {
        int x;
        int y;
        int dir;
        int dist;
        public Node (int x , int y, int dir, int dist){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.dist = dist;
        }

        @Override
        public String toString(){

            return x + "," + y + " : " + dir + " : "+ dist;
        }
    }
}
