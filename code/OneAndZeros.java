package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hgf on 2016/12/17.
 */
public class OneAndZeros {
    public static class OneZeroNums {
        public int ones;
        public int zeros;
        public OneZeroNums(String str) {
            setNums(str);
        }

        public void setNums(String str) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1')
                    this.ones++;
                else
                    this.zeros++;
            }
        }
    }
    public static void main(String[] args) {
        String[] strs= {"10", "1", "0"};
        OneZeroNums[] nums = new OneZeroNums[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = new OneZeroNums(strs[i]);
        }

        System.out.println(findMaxForm(strs, 1, 0));
    }

    /**
     * @param strs 0 and 1 sequence
     * @param m    m 0s
     * @param n    n 1s
     * @return the max form number
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }
        return findMax(list, m, n);
    }

    public static int findMax(List<String> list, int m, int n) {
        if (m < 0 || n < 0)
            return 0;
        List<String> tmp = null;
        int count = 0;
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            count = 0;
            tmp = new ArrayList<>();
            tmp.addAll(list);
            tmp.remove(i);
            int zeroNum = findNum(list.get(i), '0');
            int oneNum = findNum(list.get(i), '1');
            if (zeroNum <= m && oneNum <= n)
                count += findMax(tmp, m - zeroNum, n - oneNum) + 1;
            if (max < count)
                max = count;
        }
        return max;
    }

    public static int findNum(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
                count++;
        }
        return count;
    }
}

