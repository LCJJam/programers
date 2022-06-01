package kakao_2022;

import java.util.*;
import java.util.stream.Collectors;

public class GetReport {
    public static void main(String[] args) {


        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] id_list1 = {"con", "ryan"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        String[] report1 = {"ryan con", "ryan con", "ryan con", "ryan con"};

        int[] answer = new int[id_list.length];
        int k = 2;
        Map<String, Integer> cnt = new HashMap<>();

        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());

        HashMap<String, ArrayList<String>> toBanList = new HashMap();
        HashMap<String, Set<String>> toBanSet = new HashMap();
        for(String str : report){
            String[] sp_str = str.split(" ");
            Set<String> aSet = toBanSet.getOrDefault((sp_str[1]),new HashSet<>());
            System.out.println(aSet);

            if(!aSet.contains(sp_str[0])){
                aSet.add(sp_str[0]);
                toBanSet.put(sp_str[1],aSet);
                ArrayList<String> a = toBanList.getOrDefault((sp_str[1]),new ArrayList<>());
                a.add(sp_str[0]);
                toBanList.put(sp_str[1],a);
                System.out.println(toBanList);

            }
        }

        for(String str : id_list){
            if(toBanList.getOrDefault(str,new ArrayList<>()).size() >= k){
                for(String str2 : toBanList.get(str)){
                    cnt.put(str2,cnt.getOrDefault(str2 , 0)+1 );
                }
            }

        }

        int i = -1;
        for(String str : id_list){
            ++i;
            answer[i] = cnt.getOrDefault(str,0);
        }

        System.out.println(Arrays.toString(answer));
    }
}
