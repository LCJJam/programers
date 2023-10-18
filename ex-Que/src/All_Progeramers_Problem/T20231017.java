package All_Progeramers_Problem;

/*
 * 혼자서 하는 틱택토
 * https://school.programmers.co.kr/learn/courses/30/lessons/160585
 */
public class T20231017 {
    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};
        String[] board1 = {"...", "...", "..."};
//        String[] board2 = {"OO.", "XXX", "OO."};
        String[] board3 = {"XOO", "XXO", ".XO"};

        System.out.println(checkRule(board));
        System.out.println(checkRule(board1));
//        System.out.println(checkRule(board2));
        System.out.println(checkRule(board3));
    }

    public static int checkRule(String[] board){
        int o = 0;
        int x = 0;
        for(String i : board){
            for(int j = 0 ; j < 3 ; j++) {
                switch (i.charAt(j)) {
                    case 'O' : o++;
                        break;
                    case 'X' : x++;
                        break;
                    default: break;
                }
            }
        }

        if(o < x || o >= x+2) { // 순서가 이상할 경우
            return 0;
        }

        // 직선
        for(int i = 0; i < 3 ; i++) {
            // O가 이겼는데, 계속 진행 했을 경우
            if(board[i].charAt(0) == 'O'){

                if(board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                    if(o == x) return 0;
                }
            }

            if(board[0].charAt(i) == 'O'){
                if(board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)){
                    if(o == x) return 0;
                }
            }

            // X가 이겼는데, 계속 진행 했을 경우
            if(board[i].charAt(0) == 'X'){

                if((board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2))){
                    if(o > x) return 0;
                }
            }

            if(board[0].charAt(i) == 'X'){
                if(board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)){
                    if(o == x) return 0;
                }
            }
        }

        // 대각선
        // O가 이겼는데, 계속 진행 했을 경우
        if(( board[0].charAt(0) == 'O' && board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2))
                || (board[0].charAt(2) == 'O' && board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0))) {
                if(o == x) return 0;
        }

        // X가 이겼는데, 계속 진행 했을 경우
        if(( board[0].charAt(0) == 'X' && board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2))
                || (board[0].charAt(2) == 'X' && board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0))) {
            if(o > x) return 0;
        }


        return 1;
    }

}