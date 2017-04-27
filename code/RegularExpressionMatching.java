package code;
/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") �? false
isMatch("aa","aa") �? true
isMatch("aaa","aa") �? false
isMatch("aa", "a*") �? true
isMatch("aa", ".*") �? true
isMatch("ab", ".*") �? true
isMatch("aab", "c*a*b") �? true
*/
public class RegularExpressionMatching {
   public boolean isMatch(String target, String pattern) {
        return isMatch(target, 0, pattern, 0);
	}
	
public boolean isMatch(String s, int i, String p, int j) {
        //if the pattern finished, then test if the target string.
        if (j == p.length()) return i == s.length();
        //迭代的规则是先尽量跳�?*号匹配�?? 错误后回�?在匹配一次，再次跳过�?
        if (p.charAt(j + 1) == '*') {
            if(isMatch(s, i, p, j + 2))
                return true;
          if (isMatch(s, i, p, j + 2)
                    || i < s.length() && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))
                          &&isMatch(s, i + 1, p, j))
                return true;
        }
        else if (i < s.length() && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))
                    && isMatch(s, ++i, p, j + 1))
                    return true;
        return false;
    }
}
