public class T20220914 {
    public int solution(String[] strArr) {
        int answer = 0;
        int height = strArr.length;
        int width = strArr[0].length();
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            map[i] = strArr[i].toCharArray();
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int x = i;
                int y = j;

                // 가로 확인
                int widthCount = 0;
                for (int k = 0; k < width; k++) {
                    if (y + k >= width || map[x][y] != map[x][y + k]) break;
                    widthCount++;
                    if (widthCount >= 3) {
                        int maxHeight = 0;
                        // 세로 확인
                        // 세로 위로
                        int heightCount = 0;
                        for (int l = 0; l < height; l++) {
                            if (x - l < 0 || map[x][y] != map[x - l][y] || map[x - l][y] != map[x - l][y + widthCount - 1]) break;
                            heightCount++;
                        }
                        maxHeight = Math.max(maxHeight, heightCount);
                        // 세로 아래로
                        heightCount = 0;
                        for (int l = 0; l < height; l++) {
                            if (x + l >= height || map[x][y] != map[x + l][y] || map[x + l][y] != map[x + l][y + widthCount - 1])
                                break;
                            heightCount++;
                        }
                        maxHeight = Math.max(maxHeight, heightCount);

                        if (maxHeight >= 2) {
                            answer = Math.max(answer, maxHeight * 2 + widthCount - 2);
                        }
                    }
                }

                // 세로 확인
                int heightCount = 0;
                for (int k = 0; k < height; k++) {
                    if (x + k >= height || map[x][y] != map[x + k][y]) break;
                    heightCount++;
                    if (heightCount >= 3) {
                        int maxWidth = 0;

                        // 가로 확인
                        // 가로 왼쪽
                        widthCount = 0;
                        for (int l = 0; l < width; l++) {
                            if (y - l < 0 || x + heightCount - 1 >= height
                                    || map[x][y] != map[x][y - l] || map[x][y - l] != map[x + heightCount - 1][y - l]) break;
                            widthCount++;
                        }
                        maxWidth = Math.max(maxWidth, widthCount);
                        // 가로 오른쪽
                        widthCount = 0;
                        for (int l = 0; l < width; l++) {
                            if (y + l >= width || x + heightCount - 1 >= height
                                    || map[x][y] != map[x][y + l] || map[x][y + l] != map[x + heightCount - 1][y + l]) break;
                            widthCount++;
                        }
                        maxWidth = Math.max(maxWidth, widthCount);
                        if (maxWidth >= 2) answer = Math.max(answer, maxWidth * 2 + heightCount - 2);
                    }
                }
            }
        }
        return answer == 0 ? -1 : answer;
    }
    public static void main(String[] args) {
        T20220914 T = new T20220914();

        System.out.println(T.solution(new String[]{"AAA", "AAA", "AAA", "AAA"})); // 9
        System.out.println(T.solution(new String[]{"AAA", "ABB", "AAA"})); //7
        System.out.println(T.solution(new String[]{"BAA", "ABB", "ABB", "AAA"})); // -1
        System.out.println(T.solution(new String[]{"EHB", "AAA", "AAA", "EDE"})); // 5
        System.out.println(T.solution(new String[]{"AABB", "BABA", "AABA", "BAAA"})); // 7
        System.out.println(T.solution(new String[]{"CCBBBB","CCBBBB","CCBBBB","AABBBA", "BABABA", "AABABA", "BAAAAA"})); // 13

    }
}
