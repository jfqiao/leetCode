package algorithm.leetcode;

/**
 * Created by hgf on 2017/1/8.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord lo = new LengthOfLastWord();
        System.out.println(lo.lengthOfLastWord("hello"));
    }

    public int lengthOfLastWord(String s) {
        char[] cArr = s.toCharArray();
        int start = cArr.length - 1;
        while (start > -1 && cArr[start] == ' ')
            start--;
        int end = start;
        while (end > -1 && cArr[end] != ' ')
            end--;
        return start - end;
    }
}
