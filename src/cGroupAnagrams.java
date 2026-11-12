import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class cGroupAnagrams {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, List<String>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String str = sc.next();

            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);
        }

        List<List<String>> result = new ArrayList<>(map.values());

        System.out.println(result);

        sc.close();
    }
}