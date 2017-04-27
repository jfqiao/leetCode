package code;

import java.util.*;

/**
 * Created by hgf on 2016/12/17.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"111"};
        long t1 = System.currentTimeMillis();
        List<List<String>> list = groupAnagrams(strs);
        System.out.println(System.currentTimeMillis() - t1);
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).size(); j++) {
//                System.out.print(list.get(i).get(j) + "\t");
//            }
//            System.out.println();
//        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String value = setNum(strs[i]);
            List<String> tmpList = map.get(value);
            if (tmpList == null) {
                tmpList = new ArrayList<>();
                tmpList.add(strs[i]);
                map.put(value, tmpList);
            }
            else tmpList.add(strs[i]);
        }
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            list.add(map.get(s));
        }
        return list;
    }

    public static boolean containSame(String str1, String str2) {
//        int[] num1 = new int[26];
//        int[] num2 = new int[26];
//        setNum(str1, num1);
//        setNum(str2, num2);
//        for (int i = 0; i < 26; i++) {
//            if(num1[i] != num2[i])
//                return false;
//        }
        return true;
    }

    public static String setNum(String str) {
        int[] num = new int[26];
        for (int i = 0; i < str.length(); i++) {
            num[str.charAt(i) - 97]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            int tmp = num[i];
            while (tmp > 0) {
                sb.append(i + 97);
                tmp--;
            }
        }
        return sb.toString();
    }
}
