package algorithm.leetcode;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Stack;

/**
 * Created by hgf on 2016/12/10.
 */
public class LongestValidParentheses {

    public static void main(String[] args) {

    }

    public static int longestValidParentheses(String s) {
        int[] bits = new int[s.length()];
        for (int i = 0; i < bits.length; i++) {
            if (s.charAt(i) == '(') {
                bits[i] = 1;
            } else
                bits[i] = -1;
        }
        int preJ, j, preI;
        int i = 0;
        int curLen = 0;
        int result = 0;
        while (i < bits.length) {
            while (i < bits.length && bits[i] == -1) {
                i++;
            }
            int sum = 0;
            j = i;
            preI = i;
            preJ = j - 1;
            int count = 0;
            while (j < bits.length) {
                sum += bits[j];
                if (sum < 0) {
                    curLen = j - i;
                    if (curLen > result) {
                        result = curLen;
                    }
                    break;
                } else if (sum == 0) {
                    preJ = j;
                    curLen = j - i + 1;
                    if (curLen > result)
                        result = curLen;
                }
                if (bits[j] == -1) {

                }
                j++;
            }
            if (sum > 0) {
                curLen = j - preJ - sum - 1;
                if (curLen > result)
                    result = curLen;
            } else if (sum == 0) {
                curLen = j - i;
                if (curLen > result)
                    result = curLen;
            }
            i = j + 1;
        }
        return result;
    }

    public static int longest(String s) {
        int[] sums = new int[s.length() + 1];
        int sum = 0;
        for (int i = 1; i < sums.length; i++) {
            if (s.charAt(i - 1) == '(') {
                sum += 1;
            } else
                sum += -1;
            sums[i] = sum;
        }
        sums[0] = 0;
        int i = 0;
        int len = 0;
        while (i < sums.length - 1) {
            int j = i + len + 1;
            while (j < sums.length) {
                if (sums[j] - sums[i] < 0) {
                    i = j;
                    break;
                }
                else if (sums[j] - sums[i] == 0) {
                    if (len < j - i)
                        len = j - i;
                }
                j++;
            }
            i++;
        }
        return len;
    }

}
