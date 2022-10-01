package Programers_dev_2022;

import java.util.*;

public class TestJae {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] visited;
    static List<Island> islandList;
    static Map<Character, Integer> finalAlphaMap;

    private void searchAndUpdateIsland(int islandId, int r, int c, String[] maps) {
        // 최소/최대 범위를 안벗어나도록 체크
        if (r < 0 || r >= maps.length || c < 0 || c >= maps[0].length()){
            return;
        }

        // 바다는 가지 않도록 체크
        if (maps[r].charAt(c) == '.') {
            return;
        }

        // 이미 방문한 곳은 방문하지 않도록 체크
        if (visited[r][c] == 1) {
            return;
        }

        visited[r][c] = 1;
        char currChar = maps[r].charAt(c);
        Island currIsland = islandList.get(islandId);
        if (currIsland.winnerChar>0){
            if (currIsland.winnerChar == '-' || currIsland.alphaMap.get(currChar).equals(currIsland.alphaMap.get(currIsland.winnerChar))){
                putToFinalAlphaMap(currChar);
            } else {
                putToFinalAlphaMap(currIsland.winnerChar);
            }
        } else {
            currIsland.alphaMap.put(currChar, currIsland.alphaMap.getOrDefault(currChar, 0)+1);
        }

        for (int i=0; i<4; i++){
            searchAndUpdateIsland(islandId, r + dr[i], c + dc[i], maps);
        }
    }

    private void putToFinalAlphaMap(char c) {
        finalAlphaMap.put(c, finalAlphaMap.getOrDefault(c, 0) + 1);
    }

    private void createIslandList(String[] maps) {
        for (int r=0; r<maps.length; r++) {
            for (int c=0; c<maps[0].length(); c++) {
                if (maps[r].charAt(c) != '.' && visited[r][c] == 0){
                    islandList.add(new Island(new HashMap<>()));
                    searchAndUpdateIsland(islandList.size()-1, r, c, maps);
                }
            }
        }
    }

    private void updateIslandList(String[] maps) {
        int islandId = 0;
        for (int r=0; r<maps.length; r++) {
            for (int c=0; c<maps[0].length(); c++) {
                if (maps[r].charAt(c) != '.' && visited[r][c] == 0){
                    searchAndUpdateIsland(islandId, r, c, maps);
                    islandId++;
                }
            }
        }
    }

    private void updateWinner(List<Island> islandList) {
        for (Island island : islandList) {
            Map<Character, Integer> currIslandAlphaMap = island.alphaMap;
            List<Character> keyList = new ArrayList<>(currIslandAlphaMap.keySet());
            keyList.sort((o1, o2) -> currIslandAlphaMap.get(o2).compareTo(currIslandAlphaMap.get(o1)));

            if (keyList.size() == 1){
                island.winnerChar = keyList.get(0);
            } else {
                for (int i=1; i<keyList.size(); i++) {
                    if (currIslandAlphaMap.get(keyList.get(i-1)) > currIslandAlphaMap.get(keyList.get(i))) {
                        island.winnerChar = keyList.get(i-1);
                        break;
                    }
                    island.winnerChar = '-';
                }
            }
        }
    }

    public void solution(String[] maps) {
        visited = new int[maps.length][maps[0].length()];
        islandList = new ArrayList<>();
        finalAlphaMap = new HashMap<>();

        System.out.println("==== 시작 ====");

        printMap(maps);
        System.out.println();

        // TODO: 모든 섬을 알파벳 갯수별로 나타낸다
        createIslandList(maps);
        System.out.println(islandList);
        System.out.println();

        // TODO: 섬의 승자를 결정한다
        updateWinner(islandList);
        System.out.println("승자 결정");
        System.out.println(islandList);
        System.out.println();

        // TODO: 섬마다 승자보다 땅이 적은 나라는 승자로 대체된다
        visited = new int[maps.length][maps[0].length()];
        updateIslandList(maps);
        System.out.println("마지막 카운트");
        System.out.println(finalAlphaMap);

        // TODO: 최종 승자를 출력한다
        List<Character> keyList = new ArrayList<>(finalAlphaMap.keySet());
        keyList.sort((o1, o2) -> finalAlphaMap.get(o2).compareTo(finalAlphaMap.get(o1)));

        System.out.println(finalAlphaMap.get(keyList.get(0)));
        System.out.println("==== 끝 ====");
        System.out.println();
    }

    private void printMap(String[] maps) {
        for (String map : maps) {
            System.out.println(map);
        }
    }

    public static void main(String[] args) {
        TestJae T = new TestJae();
        String[][] inputList = new String[][] {
                new String[] {"AABCA.QA", "AABC..QX", "BBBC.Y..", ".A...T.A", "....EE..", ".M.XXEXQ", "KL.TBBBQ"},
                new String[] {"XY..", "YX..", "..YX", ".AXY"}
        };

        for (String[] input : inputList){
            T.solution(input);
        }
    }
}

class Island{
    Map<Character, Integer> alphaMap;
    char winnerChar;

    public Island(Map<Character, Integer> alphaMap){
        this.alphaMap = alphaMap;
    }

    @Override
    public String toString(){
        return "(winnerChar: " + String.valueOf(this.winnerChar) + ", alphaMap: " + alphaMap.toString() + ")";
    }
}