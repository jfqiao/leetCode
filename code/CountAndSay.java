package algorithm.leetcode;

/**
 * Created by hgf on 2016/12/10.
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.print(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n == 1)
            return "1";
        else {
            String s = countAndSay(n - 1);
            int count = 1;
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    count++;
                    i++;
                }
                result.append(count);
                result.append(s.charAt(i));
                count = 1;
            }
            return result.toString();
        }
    }
}
