import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class lottoRequst {
    public static void main(String[] args) {
        getJson();
    }

    public static void getJson() {
        try {
            //URL url = new URL("http://localhost:8080/rest/getJson");
            URL url = new URL("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=1030");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn.setRequestMethod("GET"); // http 메서드
            conn.setRequestProperty("Content-Type", "application/json"); // header Content-Type 정보
            conn.setRequestProperty("auth", "myAuth"); // header의 auth 정보
            conn.setDoOutput(true); // 서버로부터 받는 값이 있다면 true

            // 서버로부터 데이터 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
                sb.append(line);
            }
            System.out.println(sb);
            int len = (int) sb.chars()
                    .filter(c -> c == ',')
                    .count();
            String[] tmp = new String[len+1];

            sb.replace(0,1,"");
            sb.replace(sb.length()-1,sb.length(),"");

            tmp = sb.toString().replaceAll("\"","").split("\\,");
            Map<String,String> map = new HashMap<>();
            for(int i=0;i<=len;i++){
                System.out.println(tmp[i]);

                String[] tmp2 = new String[2];
                tmp2 = tmp[i].split(":");
                map.put(tmp2[0],tmp2[1]);
            }
            System.out.println(map);

            JSONObject obj = new JSONObject(map); // json으로 변경 (역직렬화)
            System.out.println(obj);
            obj.toJSONString();
            System.out.println(obj);
            //System.out.println("code= " + obj.getInt("code") + " / message= " + obj.getString("message"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
