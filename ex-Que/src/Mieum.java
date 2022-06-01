import java.util.*;
public class Mieum {

    public static void main(String[] args) {
        String[][] sample = {
                {".....",
                        ".XXX.",
                        ".X.X.",
                        ".XXX.",
                        "....."},
                {"XXXXX",
                        "XXXXX",
                        "XXX.X",
                        "XXX.X",
                        "XXXXX"},
                {"XXXXX","X...X","X.X.X","X...X","XXXXX"},
                {"....X",".....","XXX..","X.X..","XXX.."},
                {".......",
                        "XXX.XXX",
                        "X.X.X.X",
                        "XXX.XXX",
                        "......."},
                {"XXXXX","XX.XX","X...X","XX.XX","XXXXX"},
                {"XXX","X.X","XXX","X.X","XXX"},
                {"....","XX..","XX..","...."},
                {"XXXX","XXXX","XXXX","XXXX"}
        };
        boolean[] answer = new boolean[sample.length];
        Arrays.fill(answer,true);
        int pos = 0;
        for(String[] a : sample){
            boolean first = false; boolean second = false;
            boolean notB = false; boolean notW = false;
            int idx = 0;
            int outMinX = 0; int outMaxX = 0;
            int inMinX = 0; int inMaxX = 0;
            int outMinY = 0; int outMaxY = 0;
            int inMinY = 0; int inMaxY = 0;
            for(String b : a){
                if(b.indexOf('X') != -1 && !first) {
                    outMinX = b.indexOf('X');
                    outMaxX = b.lastIndexOf('X');
                    outMinY = idx;
                    outMaxY = outMinY;
                    first = true;
                }
                if(b.indexOf('X') != -1 && first){
                    // 다른 검정 섬이 있을 경우 flase
                    if(notB) {
                        answer[pos] = false;
                        break;
                    }
                    //X값이 검은섬 첫번째줄에 어긋나면 false;
                    if(b.indexOf('X') != outMinX || b.lastIndexOf('X') != outMaxX) {
                        answer[pos] = false;
                        break;
                    }
                    // 작은 하얀 섬구하기
                    String tmpStr = b.substring(b.indexOf('X'),b.lastIndexOf('X')+1);
                    if(tmpStr.indexOf('.') != -1 && !second){
                        second = true;
                        inMinX = outMinX + tmpStr.indexOf('.');
                        inMaxX = outMinX + tmpStr.lastIndexOf('.');
                        inMinY = idx;
                        inMaxY = inMinY;
                    }
                    if(tmpStr.indexOf('.') != -1 && second){
                        // 검정 내부에 다른 하얀 섬이 있을 경우 flase
                        if(notW) {
                            answer[pos] = false;
                            break;
                        }
                        String tmp2Str = tmpStr.substring(tmpStr.indexOf('.'),tmpStr.lastIndexOf('.')+1);
                        if(inMinX - tmpStr.indexOf('.') != outMinX ||
                                inMaxX - tmpStr.lastIndexOf('.') != outMinX || tmp2Str.indexOf('X') != -1){
                            answer[pos] = false;
                            break;
                        }
                        inMaxY = idx;
                    }
                    if(tmpStr.indexOf('.') == -1 && second) {
                        notW = true;
                    }
                    outMaxY = idx;
                }
                // 첫번째 검정섬 종료
                if(b.indexOf('X') == -1 && first){
                    notB = true;
                }
                if(b.indexOf('X') != -1 ) {
                    //System.out.println(b.substring(b.indexOf('X'),b.lastIndexOf('X')+1));
                }
                idx++;
            }
            if(outMinX == outMaxX || outMinY == outMaxY) {
                answer[pos] = false;
            }
            if(!notB || ! notW) answer[pos] = false;
            //System.out.println(answer[pos]);
            pos++;
        }
        System.out.println(Arrays.toString(answer));

    }
}