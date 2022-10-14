package All_Progeramers_Problem;

public class T20221007 {

    static String curStr;
    public int solution(String[] babbling) {
        int answer = 0;
        for(String babble : babbling){
            System.out.println(babble);
            curStr = "";
            while(true){
                babble = check(babble);
                if(babble.equals("")|| babble.equals("FALSE")) break;
            }
            if(babble.equals("")) {
                System.out.println(babble);
                answer++;
            }
        }
        return answer;
    }

    static String check (String babble){
        if(babble.indexOf(curStr) == 0 && !curStr.equals("") ) return "FALSE";
        char first = babble.charAt(0);
        switch(first){
            case 'a' : curStr = "aya";
                break;
            case 'y' : curStr = "ye";
                break;
            case 'w' : curStr = "woo";
                break;
            case 'm' : curStr = "ma";
                break;
            default : return "FALSE";
        }
        if(babble.indexOf(curStr) == 0){
            return babble.replaceFirst(curStr,"");
        } else {
            return "FALSE";
        }
    }

    public static void main(String[] args) {
        T20221007 T = new T20221007();
        System.out.println(T.solution(new String[]{"aya", "yee", "u", "maa"}));
        System.out.println(T.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }
}
