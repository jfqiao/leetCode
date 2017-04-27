package code;

/**
 * '*' matches a sequence (include the empty sequence)
 * the length of the matching sequence is from 0 to indefinite
 * '?' matches a single character
 * Created by hgf on 2017/1/7.
 */
public class WildcardMatching {
    public static void main(String[] args) {
        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatch("mississippi", "m*issip*"));
    }

    //默认 '*' 匹配空串，出现不匹配则回�? '*' 匹配�?次，如此�?复进�?
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean isMatch(char[] s, int sPos, char[] p, int pPos) {
        if (sPos == s.length && pPos == p.length)
            return true;
        else if (sPos == s.length) {
            //目标串匹配完毕，如果pattern剩下的全都是'*'�? 则匹配成功，否则失败
            while (pPos < p.length) {
                if (p[pPos] != '*')
                    return false;
                pPos++;
            }
            return true;
        }
        else if (pPos < p.length) {
            if (p[pPos] == '*')
                return isMatch(s, sPos, p, pPos + 1);
            else if (p[pPos] == '?' || s[sPos] == p[pPos])
                return isMatch(s, sPos + 1, p, pPos + 1);
        }
        //匹配错误，开始回溯�??
        int tmp = --pPos;
        while (pPos > -1) {
            if (p[pPos] == '*')
                break;
            pPos--;
        }
        if (pPos == -1)
            return false;
        else {
            int gap = tmp - pPos;
            return isMatch(s, sPos - gap + 1, p, pPos + 1);
        }
    }
}
