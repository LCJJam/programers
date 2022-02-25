import java.util.*;
public class Marathon {

    public static void main(String[] args) {

        String answer = "";

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String[] participant1 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion1 = {"josipa", "filipa", "marina", "nikola"};

        String[] participant2 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion2 = {"stanko", "ana", "mislav"};

        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant1) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion1) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        System.out.println(hm.keySet());
        System.out.println(answer);

    }
}
