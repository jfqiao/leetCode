package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hgf on 2016/12/17.
 */
public class PowerImplementation {

    public static void main(String[] args) {
        double x = 1.000000;
        int n = Integer.MIN_VALUE;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        long len = 0;
        if (n > 0) {
            len = n;
        } else {
            len = Math.abs((long)n);
            x = 1.0 / x;
        }

        long start = 1;
        List<Double> list = new ArrayList<>();
        while (start <= len) {
            list.add(x);
            x *= x;
            start <<= 1;
        }
        double pow = 1;
        int pos = 0;
        long count = 1;

        while (true) {
            if (count > len) {
                while (count > len) {
                    count = count >> 1;
                    pos--;
                }
                pow *= list.get(pos);
                len -= count;
            } else {
                pos++;
                count = count << 1;
            }
            if (len == 0 || count == 0)
                break;
        }

        return pow;
    }
}
